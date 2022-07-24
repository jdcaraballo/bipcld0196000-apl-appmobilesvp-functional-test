package com.banistmo.certificacion.utils;


import static com.banistmo.certificacion.utils.ManagerProperties.ENVIRONMENTS;

public class Utilities {

    public static String getEnvironments(){
        return ENVIRONMENTS.getString("environment");
    }
}
