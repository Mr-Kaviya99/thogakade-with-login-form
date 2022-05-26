package view.tm;

import javafx.scene.control.Button;

public class ItemTM {
    private String code;
    private String description;
    private double price;
    private int qtyOnHand;
    private Button btn;

    public ItemTM() {
    }

    public ItemTM(String code, String description, double price, int qtyOnHand, Button btn) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
        this.btn = btn;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
