package com.foolish.swaggerdemo.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author：chaoxianfei
 * @date：2020/1/15 10:06
 */
public class ParamUtils<T>{


    public static <T> T setValue(Map<SFunction<T, ?>, Object> map){
        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        Object obj = null;
        try {
            for (Map.Entry<SFunction<T, ?>, Object> entry : map.entrySet()) {
                SFunction<T, ?> key = entry.getKey();
                SerializedLambda serializedLambda = SerializedLambda.resolve(key);
                Class<?> implClass = serializedLambda.getImplClass();
                Field field = getFieldName(serializedLambda, implClass);
                if (Objects.nonNull(field)) {
                    if (Objects.isNull(obj)) {
                        obj = implClass.newInstance();
                    }
                    field.setAccessible(true);
                    field.set(obj, entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(obj)? null:(T)obj;
    }

    private static Field getFieldName(SerializedLambda serializedLambda, Class<?> implClass) throws NoSuchFieldException {
        String fieldName = StringUtils.resolveFieldName(serializedLambda.getImplMethodName());
        return implClass.getDeclaredField(fieldName);
    }

    public static  <T> Map<SFunction<T, ?>, Object> getMap(Class<T> filmClass){
        return new HashMap<SFunction<T, ?>, Object>();
    }




}
