package com.xiaozhen.mall.tiny.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

/**
 * @description: 自定义工具类
 * @create time:2021/10/17
 * @Author: XiaoZhen
 **/
public class MyUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyUtils.class);

    public static void upCasting(Object person, Object son) {
        Field[] fields = person.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), person.getClass());
                Object data = pd.getReadMethod().invoke(person);
                pd.getWriteMethod().invoke(son, data);
            } catch (Exception ignored) {
                LOGGER.debug(ignored.getMessage());
            }
        }
    }
}
