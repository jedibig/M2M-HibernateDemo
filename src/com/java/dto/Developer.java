package com.java.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Data
@NoArgsConstructor
public class Developer {
    @Id
    private int id;
    private String username;
    private String password;
    @ManyToMany
    private List<Project> projectList;


    public Developer(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }


}
