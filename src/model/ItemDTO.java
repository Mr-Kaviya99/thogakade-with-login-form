package model;

public class ItemDTO {
    private String code;
    private String description;
    private int qtyOnHand;
    private double price;  // Alt + Shift + Ctrl + T

    public ItemDTO() {
    }

    public ItemDTO(String code, String description, int qtyOnHand, double price) {
        this.code = code;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", price=" + price +
                '}';
    }
}
