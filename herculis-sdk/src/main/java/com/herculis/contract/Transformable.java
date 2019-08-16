package com.herculis.contract;

public interface Transformable {

    <T> T toObject(String data, Class<T> clazz);

    String toJson(Object o);

}
