package com.example.springbootdemo.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class JacksonUtil {
    @Autowired
    private ObjectMapper objectMapper;

    //对象转json字符串
    public String writeAsString(Object obj) {
        try {
            String s = objectMapper.writeValueAsString(obj);
            return s;
        } catch (JsonProcessingException e) {
            log.error("object convert json exception,obj:{}", obj);
            throw new RuntimeException(e);
        }
    }

    //json字符串转对象
    public <T> T readValue(String str, Class<T> tClass) {
        try {
            return objectMapper.readValue(str, tClass);
        } catch (JsonProcessingException e) {
            log.error("str convert Object exception,str:{},class:{}", str, tClass);
            throw new RuntimeException(e);
        }
    }

    //json字符串转集合
    public <T> List<T> readValueList(String str, Class<T> tClass) {
        try {
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            return objectMapper.readValue(str, typeFactory.constructParametricType(List.class, tClass));
        } catch (JsonProcessingException e) {
            log.error("str convert List<Object> exception,str:{},class:{}", str, tClass);
            throw new RuntimeException(e);
        }
    }

    //json对象转成map
    public <K, V> Map<K, V> readValueMap(String str, Class<K> tClass, Class<V> vClass) {
        try {
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            return objectMapper.readValue(str, typeFactory.constructParametricType(HashMap.class, tClass, vClass));
        } catch (JsonProcessingException e) {
            log.error("str convert Map<K,V> exception,str:{},tClass:{},vClass:{}", str, tClass, vClass);
            throw new RuntimeException(e);
        }
    }

    //json对象转成map
    public Map<String, String> readValueMap(String str) {
        try {

            return objectMapper.readValue(str, HashMap.class);
        } catch (JsonProcessingException e) {
            log.error("str convert Map exception,str:{}", str);
            throw new RuntimeException(e);
        }
    }
}
