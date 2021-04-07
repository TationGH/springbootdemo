package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.EmpEntity;
import com.example.springbootdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/getEname/{id}")
    public List<EmpEntity> getEnameById(String id) {
        return empService.getEnameById(id);
    }
}