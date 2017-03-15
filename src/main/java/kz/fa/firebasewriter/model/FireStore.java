package kz.fa.firebasewriter.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abay on 1/17/17.
 */
public class FireStore implements FireEntity {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String OWNER = "owner";
    public static final String TYPE = "type";
    public static final String LONGITUDE = "longitude";
    public static final String LATITUDE = "latitude";
    public static final String PHONE = "phone";
    public static final String COMPANY = "companyName";
    public static final String USERS = "users";
    public static final String CHANGE_DATE = "changeDate";
    public static final String SETTINGS = "settings";

    private String id;
    private String name;
    private String address;
    private String owner;
    private String type;
    private String companyName;

    private String phone;
    private Double longitude;
    private Double latitude;

    private Long changeDate;

    private Map<String, FireStoreUsers> users;
    private Map<String, String> settings;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Map<String, FireStoreUsers> getUsers() {
        return users;
    }

    public void setUsers(Map<String, FireStoreUsers> users) {
        this.users = users;
    }

    public Long getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Long changeDate) {
        this.changeDate = changeDate;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }
    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(ID, id);
        result.put(NAME, name);
        result.put(ADDRESS, address);
        result.put(OWNER, owner);
        result.put(TYPE, type);
        result.put(LONGITUDE, longitude);
        result.put(LATITUDE, latitude);
        result.put(PHONE, phone);
        result.put(COMPANY, companyName);
        result.put(CHANGE_DATE, changeDate);

        if (users != null && !users.isEmpty()) {
            Map<String, Object> itemsMap = new HashMap<>();

            Collection<FireStoreUsers> users = this.users.values();
            for (FireStoreUsers user : users) {
                itemsMap.put(user.getLogin(), user.toMap());
            }

            result.put(USERS, itemsMap);
        }

        return result;
    }
}
