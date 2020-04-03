package com.java.dao;


import com.java.dto.Project;

public interface ProjectRepository {
    boolean insert(Project project);
    boolean update(Project project);
    Project getById(int projectId);
}
