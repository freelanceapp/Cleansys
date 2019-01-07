package creative.creation.in.cleansys.retrofit_provider;

import android.app.Dialog;

import java.util.concurrent.TimeUnit;

import creative.creation.in.cleansys.constant.Constant;
import creative.creation.in.cleansys.modal.api_modal.Customer_Detail.CustomerDetailModel1;
import creative.creation.in.cleansys.modal.api_modal.FellowUp_responce.FellowUpModel;
import creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1.SedularModel1;
import creative.creation.in.cleansys.modal.api_modal.attechment_responce.AttechmentModel;
import creative.creation.in.cleansys.modal.api_modal.customer_responce.CutomerModel;
import creative.creation.in.cleansys.modal.api_modal.customerlist_responce.CutomerModel1;
import creative.creation.in.cleansys.modal.api_modal.price_responce.PriceModel;
import creative.creation.in.cleansys.modal.api_modal.search_responce.SearchModel;
import creative.creation.in.cleansys.modal.crew_modal.CrewMainModal;
import creative.creation.in.cleansys.modal.customer_info.CustomerInfoMainModal;
import creative.creation.in.cleansys.utils.AppProgressDialog;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static RetrofitApiClient client;
    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(80, TimeUnit.SECONDS)
            .connectTimeout(80, TimeUnit.SECONDS)
            .build();

    public RetrofitService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        client = retrofit.create(RetrofitApiClient.class);
    }

    public static RetrofitApiClient getRxClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();
        return retrofit.create(RetrofitApiClient.class);
    }

    public static RetrofitApiClient getRetrofit() {
        if (client == null)
            new RetrofitService();

        return client;
    }

    public static void getFollowUp(final Dialog dialog, final Call<FellowUpModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<FellowUpModel>() {
            @Override
            public void onResponse(Call<FellowUpModel> call, Response<FellowUpModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<FellowUpModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    public static void getCustomerInfo(final Dialog dialog, final Call<CustomerInfoMainModal> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CustomerInfoMainModal>() {
            @Override
            public void onResponse(Call<CustomerInfoMainModal> call, Response<CustomerInfoMainModal> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CustomerInfoMainModal> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    //Enter Customer
    public static void getCustomer(final Dialog dialog, final Call<CutomerModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CutomerModel>() {
            @Override
            public void onResponse(Call<CutomerModel> call, Response<CutomerModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CutomerModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    /* VendorDetail details data */
    public static void getFormFill(final Dialog dialog, final Call<CutomerModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CutomerModel>() {
            @Override
            public void onResponse(Call<CutomerModel> call, Response<CutomerModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CutomerModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    public static void getFormData(final Dialog dialog, final Call<ResponseBody> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }


    /* VendorDetail details data */
    public static void getUpdateFormFill(final Dialog dialog, final Call<CutomerModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CutomerModel>() {
            @Override
            public void onResponse(Call<CutomerModel> call, Response<CutomerModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CutomerModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    /* VendorDetail details data */
    public static void getSchedular(final Dialog dialog, final Call<SedularModel1> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<SedularModel1>() {
            @Override
            public void onResponse(Call<SedularModel1> call, Response<SedularModel1> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<SedularModel1> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    /* VendorDetail details data */
    public static void getPrice(final Dialog dialog, final Call<PriceModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<PriceModel>() {
            @Override
            public void onResponse(Call<PriceModel> call, Response<PriceModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<PriceModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    /* VendorDetail details data */
    public static void attechFile(final Dialog dialog, final Call<CutomerModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CutomerModel>() {
            @Override
            public void onResponse(Call<CutomerModel> call, Response<CutomerModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CutomerModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }


    /* VendorDetail details data */
    public static void getToken(final Dialog dialog, final Call<CutomerModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CutomerModel>() {
            @Override
            public void onResponse(Call<CutomerModel> call, Response<CutomerModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CutomerModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    /* VendorDetail details data */
    public static void customerList(final Dialog dialog, final Call<CutomerModel1> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CutomerModel1>() {
            @Override
            public void onResponse(Call<CutomerModel1> call, Response<CutomerModel1> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CutomerModel1> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }


    /* SearchList details data */
    public static void searchList(final Dialog dialog, final Call<SearchModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }


    /* SearchList details data */
    public static void jobListApi(final Dialog dialog, final Call<SearchModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    /* Delete details data */
    public static void deleteImage(final Dialog dialog, final Call<CutomerModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CutomerModel>() {
            @Override
            public void onResponse(Call<CutomerModel> call, Response<CutomerModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CutomerModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    /* VendorDetail details data */
    public static void getAttechment(final Dialog dialog, final Call<AttechmentModel> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<AttechmentModel>() {
            @Override
            public void onResponse(Call<AttechmentModel> call, Response<AttechmentModel> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<AttechmentModel> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    /* VendorDetail details data */
    public static void getCustomerDetail(final Dialog dialog, final Call<CustomerDetailModel1> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CustomerDetailModel1>() {
            @Override
            public void onResponse(Call<CustomerDetailModel1> call, Response<CustomerDetailModel1> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CustomerDetailModel1> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

    public static void getCrewUserList(final Dialog dialog, final Call<CrewMainModal> method, final WebResponse webResponse) {
        if (dialog != null)
            AppProgressDialog.show(dialog);

        method.enqueue(new Callback<CrewMainModal>() {
            @Override
            public void onResponse(Call<CrewMainModal> call, Response<CrewMainModal> response) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                WebServiceResponse.handleResponse(response, webResponse);
            }

            @Override
            public void onFailure(Call<CrewMainModal> call, Throwable throwable) {
                if (dialog != null)
                    AppProgressDialog.hide(dialog);
                webResponse.onResponseFailed(throwable.getMessage());
            }
        });
    }

}