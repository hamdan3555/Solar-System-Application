package Models;

public class ModelOrderNow {
    public String address;
    public String quantity;
    public String product_code;
    public String contact_number;

    public ModelOrderNow() {
    }

    public ModelOrderNow(String address, String quantity, String product_code, String contact_number) {
        this.address = address;
        this.quantity = quantity;
        this.product_code = product_code;
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }
}
