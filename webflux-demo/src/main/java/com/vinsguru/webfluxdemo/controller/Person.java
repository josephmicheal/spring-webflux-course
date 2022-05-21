package com.vinsguru.webfluxdemo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long id;
    private long deptId;
    private String name;
}
