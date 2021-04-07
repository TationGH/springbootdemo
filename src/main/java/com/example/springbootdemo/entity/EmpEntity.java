package com.example.springbootdemo.entity;

import lombok.Data;

@Data
public class EmpEntity {
    private String id;
    private String ename;
    private String jobId;
    private String mgr;
    private String joindate;
    private String salary;
    private String bonus;
    private String deptId;
}
