package com.herculis.util;

import com.herculis.annotation.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FieldMapper {

    private static final Logger LOGGER = Logger.getLogger(FieldMapper.class.getName());

    public static Map<String, String> mapObjectFields(Object o){
        Map<String, String> mappedFields = new HashMap<String, String>();
        java.lang.reflect.Field[] fields = o.getClass().getDeclaredFields();
        for (java.lang.reflect.Field item : fields) {
            try {
                item.setAccessible(Boolean.TRUE);
                String fieldName = item.getName();
                Field field = item.getAnnotation(Field.class);
                if(field != null){
                    if(field.ignored()){
                        continue;
                    }
                    String fieldValue = field.value();
                    fieldName = !"".equals(fieldValue) ? fieldValue : fieldName;
                }

                String value = String.valueOf(item.get(o));
                mappedFields.put(fieldName.toUpperCase(), value);
            } catch (IllegalAccessException e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        }
        return mappedFields;
    }

}
