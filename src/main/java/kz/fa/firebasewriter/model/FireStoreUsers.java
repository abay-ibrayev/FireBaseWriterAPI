package kz.fa.firebasewriter.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abay on 1/17/17.
 */
public class FireStoreUsers implements FireEntity {
    public static final String LOGIN = "login";
    public static final String NAME = "name";
    public static final String ROLE = "role";

    private String login;
    private String name;
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<>();
        result.put(LOGIN, login);
        result.put(NAME, name);
        result.put(ROLE, role);
        return result;
    }
}
