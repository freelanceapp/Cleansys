package creative.creation.in.cleansys.model;

public class PriceModel1 {
    String price_time;
    String price_amount;

    public PriceModel1() {
    }

    public PriceModel1(String price_time, String price_amount) {
        this.price_time = price_time;
        this.price_amount = price_amount;
    }

    public String getPrice_time() {
        return price_time;
    }

    public void setPrice_time(String price_time) {
        this.price_time = price_time;
    }

    public String getPrice_amount() {
        return price_amount;
    }

    public void setPrice_amount(String price_amount) {
        this.price_amount = price_amount;
    }
}
