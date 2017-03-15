package kz.fa.firebasewriter.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abay on 1/18/17.
 */
public class FireReceipt implements FireEntity {
    public static final String ID = "id";
    public static final String OPER_DATE = "operationDateTime";
    public static final String CASHIER = "cashierId";
    public static final String KKM = "kkmCashDeskCode";
    public static final String AMOUNT = "amount";
    public static final String FISCALIZATION = "fiscalEnabled";
    public static final String PAYMENT = "payment";
    public static final String CASHBACK = "cashback";
    public static final String TAX = "tax";
    public static final String RECEIPT_NUM = "receiptNum";
    public static final String FISCAL = "fiscal";
    public static final String STORE_ID = "storeId";
    public static final String BILL_ID = "billId";
    public static final String STORNO_ID = "stornoId";
    public static final String DEVICE_ID = "deviceId";
    public static final String COMPANY = "companyName";


    private String id;
    private Long operationDateTime;
    private String cashierId;
    private String kkmCashDeskCode;
    private Double amount;
    private Boolean fiscalEnabled;
    private Double payment;
    private Double cashback;
    private String receiptNum;
    private String fiscal;
    private String billId;
    private String storeId;
    private String stornoId;
    private String deviceId;
    private String companyName;

    public FireReceipt() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOperationDateTime() {
        return operationDateTime;
    }

    public void setOperationDateTime(Long operationDateTime) {
        this.operationDateTime = operationDateTime;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getKkmCashDeskCode() {
        return kkmCashDeskCode;
    }

    public void setKkmCashDeskCode(String kkmCashDeskCode) {
        this.kkmCashDeskCode = kkmCashDeskCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getFiscalEnabled() {
        return fiscalEnabled;
    }

    public void setFiscalEnabled(Boolean fiscalEnabled) {
        this.fiscalEnabled = fiscalEnabled;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getCashback() {
        return cashback;
    }

    public void setCashback(Double cashback) {
        this.cashback = cashback;
    }

    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }

    public String getFiscal() {
        return fiscal;
    }

    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(ID, id);
        result.put(OPER_DATE, operationDateTime);
        result.put(CASHIER, cashierId);
        result.put(KKM, kkmCashDeskCode);
        result.put(COMPANY, companyName);
        result.put(AMOUNT, amount);
        result.put(FISCALIZATION, fiscalEnabled);
        result.put(PAYMENT, payment);
        result.put(CASHBACK, cashback);
        result.put(RECEIPT_NUM, receiptNum);
        result.put(FISCAL, fiscal);
        result.put(STORE_ID, storeId);
        result.put(BILL_ID, billId);
        result.put(STORNO_ID, stornoId);
        result.put(DEVICE_ID, deviceId);
        return result;
    }
}
