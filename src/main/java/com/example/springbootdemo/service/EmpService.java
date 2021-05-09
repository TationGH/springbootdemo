package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.EmpEntity;

import java.util.List;

public interface EmpService {
    List<EmpEntity> getEnameById(String id);
}