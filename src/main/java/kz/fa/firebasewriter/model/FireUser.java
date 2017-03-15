package kz.fa.firebasewriter.model;

import java.util.Map;

/**
 * Created by abay on 1/17/17.
 */
public class FireUser {
    private String login;
    private String name;
    private String password;
    private String role;
    private Long lastLogin;
    private Map<String, FireUserStores> stores;

    public FireUser() {
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Long getLastLogin() {
        return lastLogin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Map<String, FireUserStores> getStores() {
        return stores;
    }

    public void setStores(Map<String, FireUserStores> stores) {
        this.stores = stores;
    }
}
