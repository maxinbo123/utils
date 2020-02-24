package com.kenan.utils.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 类与map的相互转换
 */
public class BeanUtil {
    /**
     * 把map对象转换为javabean
     * @param map
     * @param beantype
     * @param <T>
     * @return
     * @throws Exception
     */
    public  static <T> T map2bean(Map<String, Object> map, Class<T> beantype) throws Exception{
        T object=beantype.newInstance();
        //获取类的属性描述器
        BeanInfo beaninfo= Introspector.getBeanInfo(beantype,Object.class);
        //获取类的属性集
        PropertyDescriptor[] pro=beaninfo.getPropertyDescriptors();
        for (PropertyDescriptor property : pro) {
            //获取属性的名字
            String name=property.getName();
            //得到属性name在map中对应的value。
            Object value=map.get(name);
            //得到属性的set方法
            Method set=property.getWriteMethod();
            //接下来将map的value转换为属性的value
            set.invoke(object, value);
        }
        return object;
    }

    /**
     * 将javabean转换为map
     * @param bean
     * @return
     * @throws Exception
     */
    public static Map<String,Object> javabean2map(Object bean) throws Exception{
        Map<String, Object> map=new HashMap<>();
        //获取类的属性描述器
        BeanInfo beaninfo=Introspector.getBeanInfo(bean.getClass(),Object.class);
        //获取类的属性集
        PropertyDescriptor[] pro=beaninfo.getPropertyDescriptors();
        for (PropertyDescriptor property : pro) {
            String key=property.getName();
            Method get=property.getReadMethod();
            Object value=get.invoke(bean);
            map.put(key, value);
        }
        return map;
    }
}
