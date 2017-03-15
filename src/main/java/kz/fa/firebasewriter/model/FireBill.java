package kz.fa.firebasewriter.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abay on 1/17/17.
 */
public class FireBill implements  FireEntity {
    public static final String ID = "id";
    public static final String PARENT_BILL = "parentBillId";
    public static final String TYPE = "type";
    public static final String TOTAL_SUM = "totalSum";
    public static final String DATE = "transactionDate";
    public static final String BILL_NUM = "billNum";
    public static final String USER = "user";
    public static final String CONTR = "contragent";
    public static final String STORNO_ID = "stornoId";
    public static final String DEVICE_ID = "deviceId";
    public static final String ITEMS = "items";

    private String id;
    private String parentBillId;
    private String type;
    private double totalSum;
    private Long transactionDate;
    private String billNum;
    private String user;
    private String contragent;
    private String stornoId;
    private String deviceId;
    private Map<String, FireBillItem> items;

    public FireBill() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentBillId() {
        return parentBillId;
    }

    public void setParentBillId(String parentBillId) {
        this.parentBillId = parentBillId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public Long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Long transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContragent() {
        return contragent;
    }

    public void setContragent(String contragent) {
        this.contragent = contragent;
    }

    public String getStornoId() {
        return stornoId;
    }

    public void setStornoId(String stornoId) {
        this.stornoId = stornoId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Map<String, FireBillItem> getItems() {
        if (items == null) {
            return Collections.EMPTY_MAP;
        }
        return items;
    }

    public void setItems(Map<String, FireBillItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "FireBill{" +
                "id='" + id + '\'' +
                ", parentBillId='" + parentBillId + '\'' +
                ", type='" + type + '\'' +
                ", totalSum=" + totalSum +
                ", transactionDate=" + transactionDate +
                ", billNum='" + billNum + '\'' +
                ", user='" + user + '\'' +
                ", contragent='" + contragent + '\'' +
                ", stornoId='" + stornoId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(ID, id);
        result.put(PARENT_BILL, parentBillId);
        result.put(TYPE, type);
        result.put(TOTAL_SUM, totalSum);
        result.put(DATE, transactionDate);
        result.put(BILL_NUM, billNum);
        result.put(USER, user);
        result.put(CONTR, contragent);
        result.put(STORNO_ID, stornoId);
        result.put(DEVICE_ID, deviceId);

        if (items != null && !items.isEmpty()) {
            Map<String, Object> itemsMap = new HashMap<>();

            Collection<FireBillItem> billItems = items.values();
            for (FireBillItem item : billItems) {
                itemsMap.put(item.getId(), item.toMap());
            }

            result.put(ITEMS, itemsMap);
        }


        return result;
    }
}
