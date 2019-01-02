package creative.creation.in.cleansys.model;

public class Jobs {
    private String id;
    private String data;
    private String customer;
    private String estm_price;
    private String assets;
    private String crew_memner;

    public Jobs(String id, String data, String customer, String estm_price, String assets, String crew_memner) {
        this.id = id;
        this.data = data;
        this.customer = customer;
        this.estm_price = estm_price;
        this.assets = assets;
        this.crew_memner = crew_memner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEstm_price() {
        return estm_price;
    }

    public void setEstm_price(String estm_price) {
        this.estm_price = estm_price;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public String getCrew_memner() {
        return crew_memner;
    }

    public void setCrew_memner(String crew_memner) {
        this.crew_memner = crew_memner;
    }
}
