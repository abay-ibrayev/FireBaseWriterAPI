package kz.fa.firebasewriter.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abay on 1/17/17.
 */
public class FirePrice implements FireEntity {

    public static final String TYPE = "type";
    public static final String PRICE = "price";
    public static final String DATE = "dateBegin";

    private String type;
    private Double price;
    private Long dateBegin;

    public FirePrice() {
    }

    public FirePrice(Double price, Long dateBegin, String type) {
        this.price = price;
        this.dateBegin = dateBegin;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.toLowerCase();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Long dateBegin) {
        this.dateBegin = dateBegin;
    }


    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(TYPE, type);
        result.put(PRICE, price);
        result.put(DATE, dateBegin);
        return result;
    }
}