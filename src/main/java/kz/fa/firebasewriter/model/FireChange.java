package kz.fa.firebasewriter.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import java.io.Serializable;

/**
 *
 * @author Nur4I
 */
@IgnoreExtraProperties
public class FireChange implements Serializable {

    @Exclude
    public static final String PATH_CHANGES = "changes";
    @Exclude
    public static final String PATH_TEMP = "temp";

    @Exclude
    public static final String FIELD_DEVICE = "deviceId";
    @Exclude
    public static final String FIELD_STORE = "storeId";
    @Deprecated
    @Exclude
    public static final String FIELD_PATH = "path";
    @Exclude
    public static final String FIELD_ACTION = "action";
    @Exclude
    public static final String FIELD_TYPE = "type";
    @Exclude
    public static final String FIELD_OBJECT = "object";

    @Exclude
    public static final String ACTION_UPDATE = "update";
    @Exclude
    public static final String ACTION_DELETE = "delete";
    @Exclude
    public static final String TYPE_BILL = "bill";
    @Exclude
    public static final String TYPE_RECEIPT = "receipt";
    @Exclude
    public static final String TYPE_CASHBOX = "cashbox";

    private String deviceId;
    private String storeId;
    @Deprecated
    private String path;
    private String action;
    private String type;
    private Long st;
    private Object object;

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

    @Deprecated
    public String getPath() {
        return path;
    }

    @Deprecated
    public void setPath(String path) {
        this.path = path;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Long getSt() {
        return st;
    }

    @Override
    public String toString() {
        return "FireChange{" + "action=" + action + ", type=" + type + ", st=" + st + ", object=" + object + '}';
    }

}
