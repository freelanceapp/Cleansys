package creative.creation.in.cleansys.util;

import static creative.creation.in.cleansys.constant.Constant.BASE_URL;

public class WebApi {
//http://codeencrypt.in/cleansys/api/

    public static final String API_LOGIN = BASE_URL + "api/login.php";

    public static final String API_CREATE_CUSTOMER = BASE_URL + "api/create_customer.php";

    // GET
    public static final String API_ALL_CUSTOMER = BASE_URL + "api/select_customer.php";
    public static final String API_CREW_LIST = BASE_URL + "api/available.php";

    public static final String API_JOB_LIST = BASE_URL + "api/job_list.php";
    public static final String API_FELLOW_LIST = BASE_URL + "api/follow_up.php";
    public static final String API_FORGOT = BASE_URL + "api/follow_up.php";
    public static final String API_PRICE = BASE_URL + "api/price_list.php";
}
