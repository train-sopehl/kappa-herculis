package com.herculis.transform;

import com.herculis.contract.Transformable;
import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;

public class JsoniterTransformer implements Transformable {

    @Override
    public <T> T toObject(String data, Class<T> clazz) {
        return JsonIterator.deserialize(data, clazz);
    }

    @Override
    public String toJson(Object o) {
        return JsonStream.serialize(o);
    }

}
