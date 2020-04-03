package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
    @Id
    int projectID;
    String name;
    @ManyToMany
    List<Developer> developers;

    public Project(int projectID, String name) {
        this.projectID = projectID;
        this.name = name;
    }
}
