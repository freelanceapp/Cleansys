package creative.creation.in.cleansys.activity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.AttechmentAdapter;
import creative.creation.in.cleansys.modal.api_modal.attechment_responce.AttechmentFile;
import creative.creation.in.cleansys.modal.api_modal.attechment_responce.AttechmentModel;
import creative.creation.in.cleansys.modal.api_modal.customer_responce.CutomerModel;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.util.ConnectionDetector;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;

public class AttechmentActivity extends BaseActivity implements View.OnClickListener {
    private File file = null;
    private int GALLERY = 1, CAMERA = 2;
    private String userChoosenTask;
    private static final String IMAGE_DIRECTORY = "/musteat";
    private View rootView;
    private static FragmentManager fragmentManager;
    Context ctx;
    Button bt_send_btn;
    ImageView back_btn, iv_image;
    private static final int MY_PERMISSIONS_REQUEST_CODE = 123;
    String jobId;
    ConnectionDetector connectionDetector;
    //SessionManager sessionManager;
    RecyclerView attechmentList;
    AttechmentAdapter attechmentAdapter;
    ArrayList<AttechmentFile> attechmentFileArrayList = new ArrayList<>();
    private Uri Download_Uri;
    private DownloadManager downloadManager;
    private ArrayList<Long> list = new ArrayList<>();
    private long refid;
    String fileURL;
    String songName;
    String atId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attechment);
        initXml();
        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        jobId = getIntent().getStringExtra("job_id");
        Log.e("Job ID", "..." + jobId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();
        }
        attechmentApi();
        attechmentAdapter = new AttechmentAdapter(ctx, attechmentFileArrayList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        attechmentList.setLayoutManager(mLayoutManager);
        attechmentList.setItemAnimator(new DefaultItemAnimator());
        attechmentList.setAdapter(attechmentAdapter);

        //checkLogin();
    }

    private void initXml() {
        ctx = this;
        mContext = this;
        cd = new creative.creation.in.cleansys.utils.ConnectionDetector(mContext);
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        bt_send_btn = findViewById(R.id.bt_send_btn);
        back_btn = findViewById(R.id.back_btn);
        iv_image = findViewById(R.id.iv_image);
        attechmentList = findViewById(R.id.attechmentList);
        bt_send_btn.setOnClickListener(this);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectImage();
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_send_btn:
                api();
                break;

            case R.id.ivAttechmentDown:
                int pos = Integer.parseInt(view.getTag().toString());
                getSongUrl(pos);
                break;

            case R.id.ivAttechmentDelete:
                int pos1 = Integer.parseInt(view.getTag().toString());
                AttechmentFile attechmentFile = attechmentFileArrayList.get(pos1);
                atId = attechmentFile.getAttachId();
                attechmentDeleteApi();
                break;
        }
    }

    /*
     * Capture image
     * */
    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                //boolean result= Utility.checkPermission(getActivity());

                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";
                    cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), GALLERY);
		/*Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(galleryIntent, GALLERY);*/
    }

    private void cameraIntent() {
		/*Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		startActivityForResult(intent, CAMERA);*/
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(ctx.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    //  Toast.makeText(ctx, "Image Saved!", Toast.LENGTH_SHORT).show();
                    iv_image.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(ctx, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            iv_image.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            // Toast.makeText(ctx, "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        Log.e("File", wallpaperDirectory.getPath());
        Log.e("wallpaperDirectory", "..." + wallpaperDirectory.exists());
        Log.e("wallpaperDirectory", "===" + wallpaperDirectory.mkdirs());
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            file = new File(wallpaperDirectory, System.currentTimeMillis() + "Cleansysimg.jpg");
            file.createNewFile();
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(ctx, new String[]{file.getPath()}, new String[]{"image/*"}, null);
            fo.close();
            Log.e("TAG", "File Saved::--->" + file.getAbsolutePath());
            return file.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    protected void checkPermission() {
        if (ContextCompat.checkSelfPermission(AttechmentActivity.this, Manifest.permission.CAMERA)
                + ContextCompat.checkSelfPermission(AttechmentActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Do something, when permissions not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    AttechmentActivity.this, Manifest.permission.CAMERA)
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    AttechmentActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // If we should give explanation of requested permissions
                // Show an alert dialog here with request explanation
                AlertDialog.Builder builder = new AlertDialog.Builder(AttechmentActivity.this);
                builder.setMessage("Camera and Write External" +
                        " Storage permissions are required to do the task.");
                builder.setTitle("Please grant those permissions");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(
                                AttechmentActivity.this,
                                new String[]{Manifest.permission.CAMERA,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                                },
                                MY_PERMISSIONS_REQUEST_CODE
                        );
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                // Directly request for required permissions, without explanation
                ActivityCompat.requestPermissions(
                        AttechmentActivity.this,
                        new String[]{
                                Manifest.permission.CAMERA,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        },
                        MY_PERMISSIONS_REQUEST_CODE
                );
            }
        } else {
            // Do something, when permissions are already granted
            Toast.makeText(ctx, "Permissions already granted", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CODE: {
                // When request is cancelled, the results array are empty
                if (
                        (grantResults.length > 0) &&
                                (grantResults[0] + grantResults[1] == PackageManager.PERMISSION_GRANTED
                                )
                        ) {
                    // Permissions are granted
                    Toast.makeText(ctx, "Permissions granted.", Toast.LENGTH_SHORT).show();

                    // close this activity
                } else {
                    // Permissions are denied
                    Toast.makeText(ctx, "Permissions denied.", Toast.LENGTH_SHORT).show();
                    finish();
                }
                return;
            }
        }
    }

    public void api() {
        if (file == null) {
            Toast.makeText(ctx, "Please select Image", Toast.LENGTH_LONG).show();
        } else {

            if (cd.isNetworkAvailable()) {
                RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("fileToUpload", file.getName(), mFile);
                RequestBody name = RequestBody.create(MediaType.parse("text/plain"), jobId);
                RetrofitService.attechFile(new Dialog(mContext), retrofitApiClient.attechFile(name, fileToUpload), new WebResponse() {
                    @Override
                    public void onResponseSuccess(Response<?> result) {
                        CutomerModel loginModal = (CutomerModel) result.body();
                        assert loginModal != null;
                        if (!loginModal.getError()) {
                            Alerts.show(mContext, loginModal.getMessage());
                        } else {
                            Alerts.show(mContext, loginModal.getMessage());
                        }
                        attechmentApi();
                    }

                    @Override
                    public void onResponseFailed(String error) {
                        Alerts.show(mContext, error);
                    }
                });
            } else {
                cd.show(mContext);
            }
        }
    }


    public void attechmentApi() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.getAttechment(new Dialog(mContext), retrofitApiClient.getAttechment(jobId), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    AttechmentModel attechmentModel = (AttechmentModel) result.body();
                    assert attechmentModel != null;
                    attechmentFileArrayList.clear();
                    if (attechmentModel.getFile() == null)
                        return;
                    if (!attechmentModel.getError()) {
                        attechmentFileArrayList.addAll(attechmentModel.getFile());
                    } else {
                        Alerts.show(mContext, attechmentModel.getMessage());
                    }
                    attechmentAdapter.notifyDataSetChanged();
                }

                @Override
                public void onResponseFailed(String error) {
                    Alerts.show(mContext, error);
                }
            });
        } else {
            cd.show(mContext);
        }
    }

    //delete
    public void attechmentDeleteApi() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.deleteImage(new Dialog(mContext), retrofitApiClient.deleteImage(atId), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    CutomerModel loginModal = (CutomerModel) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        Alerts.show(mContext, loginModal.getMessage());
                        attechmentApi();
                    } else {
                        Alerts.show(mContext, loginModal.getMessage());
                    }
                    attechmentAdapter.notifyDataSetChanged();
                }

                @Override
                public void onResponseFailed(String error) {
                    Alerts.show(mContext, error);
                }
            });
        } else {
            cd.show(mContext);
        }
    }

    private void getSongUrl(int pos) {
        AttechmentFile favourite = attechmentFileArrayList.get(pos);
        fileURL = favourite.getAttachPath();
        fileURL = fileURL.replace(" ", "%20");
        songName = favourite.getJobId();
        Download_Uri = Uri.parse("http://codeencrypt.in/cleansys/uploads/Copy%20of%20Diwali%20-%20Made%20with%20PosterMyWall.jpg");
        if (fileURL.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No url found", Toast.LENGTH_SHORT).show();
        } else {
            downLoadManagerSong();
        }
    }

    private void downLoadManagerSong() {
        DownloadManager.Request request = new DownloadManager.Request(Download_Uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setAllowedOverRoaming(false);
        request.setTitle("Cleansys Downloading " + songName);
        request.setDescription("Downloading " + songName);
        request.setVisibleInDownloadsUi(true);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/cleansys/" + songName);
        refid = downloadManager.enqueue(request);
        Log.e("OUT", "" + refid);
    }

    BroadcastReceiver onComplete = new BroadcastReceiver() {
        public void onReceive(Context ctxt, Intent intent) {
            long referenceId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            Log.e("IN", "" + referenceId);
            list.remove(referenceId);
            if (list.isEmpty()) {
                Log.e("INSIDE", "" + referenceId);
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(ctx.getApplicationContext())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Clean Sys");


                NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(455, mBuilder.build());
            }
        }
    };

}
