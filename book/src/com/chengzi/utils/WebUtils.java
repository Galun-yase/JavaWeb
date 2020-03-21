package com.chengzi.utils;


import org.apache.commons.beanutils.BeanUtils;
import java.util.Map;

public class WebUtils {

    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue){
        try{
            return Integer.parseInt(strInt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return defaultValue;
    }

}
