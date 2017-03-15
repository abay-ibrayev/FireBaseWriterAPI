package kz.fa.firebasewriter.model;

import java.util.Map;

/**
 * Created by abay on 1/18/17.
 */
public class FireSettings implements FireEntity {
    private String value;
    private long changeDate;
    private double amount;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(long changeDate) {
        this.changeDate = changeDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public Map<String, Object> toMap() {
        return null;
    }
}
