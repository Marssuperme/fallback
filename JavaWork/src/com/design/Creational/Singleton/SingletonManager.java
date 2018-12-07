package com.design.Creational.Singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 将多种单例类型注入到一个统一的管理类中，在使用时根据key获取对象
 * 对应类型的对象。这种方式使得我们可以管理多种类型的单例，并且在使
 * 用时可以通过统一的接口进行获取操作，降低了用户的使用成本，也对用
 * 户隐藏了具体实现，降低了耦合度。
 */
public class SingletonManager {

    private static Map<String,Object> objMap = new HashMap<String,Object>();
    private SingletonManager() { }
    public static void registerService(String key, Object instance) {
        if(!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }
    public static Object getService(String key) {
        return objMap.get(key);
    }

}
