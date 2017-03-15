package kz.fa.firebasewriter.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abay on 1/17/17.
 */
public class FireBillItem implements FireEntity{
    public static final String ID = "id";
    public static final String POSITION = "position";
    public static final String GOOD_ID = "goodId";
    public static final String AMOUNT = "quantity";
    public static final String PRICE = "price";
    public static final String BARCODE = "barcode";
    public static final String STATUS = "status";

    private String id;
    private Integer position;
    private String goodId;
    private double quantity;
    private FirePrice price;
    private String barcode;
    private String status;

    public FireBillItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public FirePrice getPrice() {
        return price;
    }

    public void setPrice(FirePrice price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(ID, id);
        result.put(POSITION, position);
        result.put(GOOD_ID, goodId);
        result.put(AMOUNT, quantity);
        result.put(PRICE, price.toMap());
        result.put(BARCODE, barcode);
        result.put(STATUS, status);
        return result;
    }
}
