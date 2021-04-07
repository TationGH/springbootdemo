package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.EmpEntity;
import com.example.springbootdemo.mapper.EmpMapper;
import com.example.springbootdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<EmpEntity> getEnameById(String id) {
        return empMapper.getEnameById(id);
    }
}
