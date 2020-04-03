package com.java.dao;

import com.java.dto.Developer;

import java.util.List;

public interface DeveloperRepository {
    boolean insert(Developer u);
    boolean update(Developer u);
    Developer getById(int id);

}
