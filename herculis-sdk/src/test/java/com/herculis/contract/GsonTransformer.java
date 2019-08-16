package com.herculis.contract;

import com.google.gson.Gson;

public class GsonTransformer implements Transformable {

    @Override
    public <T> T toObject(String data, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(data, clazz);
    }

    @Override
    public String toJson(Object o) {
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
