package kz.fa.firebasewriter.model;

import java.util.Map;

/**
 * Created by abay on 1/18/17.
 */
public class FireGoodType {

    private String caption;
    private String code;
    private String id;
    private Long localId;
    private String parentId;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "FireGoodType{" +
                "caption='" + caption + '\'' +
                ", code='" + code + '\'' +
                ", id='" + id + '\'' +
                ", localId=" + localId +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
