package com.pan.factory;

import com.pan.config.FrameworkConfig;
import org.aeonbits.owner.ConfigCache;

//Final class to restrict inheritance by other classes
public final class ConfigFactory {
    //Private constructor since this has only static method and to avoid creation of instances of this class
    private ConfigFactory(){}

    public static FrameworkConfig getconfig(){
        //Implement Singleton pattern using Config cache to ensure only one instance creation for FrameworkConfig class
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }
}
