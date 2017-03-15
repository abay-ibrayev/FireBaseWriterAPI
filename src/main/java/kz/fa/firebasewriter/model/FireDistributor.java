package kz.fa.firebasewriter.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abay on 1/18/17.
 */
public class FireDistributor implements FireEntity {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DEBT = "debt";
    public static final String CHANGE_DATE = "changeDate";
    public static final String ADDRESS = "address";
    public static final String TELEPHONE = "telephone";
    public static final String EMAIL = "email";
    public static final String MEMBER_NAME = "memberName";
    public static final String MEMBER_POS = "memberPosition";
    public static final String MEMBER_PHONE = "memberPhone";

    private String id;
    private String name;
    private double debt;
    private long changeDate;
    private String address;
    private String telephone;
    private String email;
    private String nameOfMember;
    private String positionOfMember;
    private String telephoneOfMember;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public long getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(long changeDate) {
        this.changeDate = changeDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameOfMember() {
        return nameOfMember;
    }

    public void setNameOfMember(String nameOfMember) {
        this.nameOfMember = nameOfMember;
    }

    public String getPositionOfMember() {
        return positionOfMember;
    }

    public void setPositionOfMember(String positionOfMember) {
        this.positionOfMember = positionOfMember;
    }

    public String getTelephoneOfMember() {
        return telephoneOfMember;
    }

    public void setTelephoneOfMember(String telephoneOfMember) {
        this.telephoneOfMember = telephoneOfMember;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(ID, id);
        result.put(NAME, name);
        result.put(DEBT, debt);
        result.put(CHANGE_DATE, changeDate);
        result.put(ADDRESS, address);
        result.put(TELEPHONE, telephone);
        result.put(EMAIL, email);
        result.put(MEMBER_NAME, telephoneOfMember);
        result.put(MEMBER_POS, positionOfMember);
        result.put(MEMBER_PHONE, telephoneOfMember);
        return result;
    }
}
