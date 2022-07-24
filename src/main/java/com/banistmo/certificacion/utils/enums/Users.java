package com.banistmo.certificacion.utils.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.banistmo.certificacion.utils.Utilities.getEnvironments;

public enum Users {
    ELIZABETH("Dev", "Colombia", "person", "91TmUTqErdFLyyz6jWmAXg==", "lzEU3IkqW/J+dakHgSzStw=="),
    SALVATORE("Dev", "Colombia", "company", "39rc2seaTDT3tGd2XsO4ac54unv6bOrePg6QYylwiSqKU5hZJI8d7A==", "fjlANY6iN2H9ckb6QKtkTg=="),
    ANTONIO("Dev", "Mexico", "person", "39rc2seaTDRmkkSljCT6s854unv6bOrePg6QYylwiSqKU5hZJI8d7A==", "Yi0pZtylqWPh88mo2eusRA=="),
    REINA("Dev", "Mexico", "company", "39rc2seaTDTohL/rcyqTys54unv6bOrePg6QYylwiSqKU5hZJI8d7A==", "lPiHH90UD+vUt8582wP8dA=="),
    AUTOTDC("Prod", "Colombia", "person", "FSlFE0TSpUPozU+2gQ7Cqwq5lbJQSGX63XJNwSHbbl0=", "PVK1UvuNhfVjUlrKRBSIVg==");

    private final String environment;
    private final String country;
    private final String accountType;
    private final String email;
    private final String password;

    Users(String environment, String country, String accountType, String email, String password) {
        this.environment = environment;
        this.country = country;
        this.accountType = accountType;
        this.email = email;
        this.password = password;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public static Map<String, String> getUsers(String country, String accountType) {
        Map<String, String> data = new LinkedHashMap<>();
        for (Users users : Users.values()) {
            if (getEnvironments().equals(users.getEnvironment()) &&
                    country.equalsIgnoreCase(users.getCountry()) &&
                    accountType.equals(users.getAccountType())) {
                data.put("email", users.getEmail());
                data.put("password", users.getPassword());
                break;
            }
        }
        return data;
    }
}
