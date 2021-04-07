package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.EmpEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    List<EmpEntity> getEnameById(String id);
}