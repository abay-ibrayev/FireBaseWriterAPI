package kz.fa.firebasewriter.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abay on 1/17/17.
 */
public class FireUserStores implements FireEntity {
    public static final String NAME = "name";
    public static final String SHOP_TYPE = "shopType";
    public static final String ROLE_IN_SHOP = "roleInShop";
    public static final String STORE_ID = "storeId";

    private String name;
    private String shopType;
    private String roleInShop;
    private String storeId;

    public FireUserStores() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getRoleInShop() {
        return roleInShop;
    }

    public void setRoleInShop(String roleInShop) {
        this.roleInShop = roleInShop;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(NAME, name);
        result.put(SHOP_TYPE, shopType);
        result.put(ROLE_IN_SHOP, roleInShop);
        result.put(STORE_ID, storeId);
        return result;
    }
}
