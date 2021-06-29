package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.EmpEntity;

import java.util.List;

//@Mapper
public interface EmpMapper {
    List<EmpEntity> getEnameById(String id);
}