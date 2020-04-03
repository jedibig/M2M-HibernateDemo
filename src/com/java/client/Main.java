package com.java.client;

import com.java.dao.ProjectRepository;
import com.java.dao.ProjectRepositoryImpl;
import com.java.dao.DeveloperRepository;
import com.java.dao.DeveloperRepositoryImpl;
import com.java.dto.Developer;
import com.java.dto.Project;

import java.util.Arrays;
import java.util.List;

public class Main {
    static DeveloperRepository userRepository = new DeveloperRepositoryImpl();
    static ProjectRepository projectRepository = new ProjectRepositoryImpl();

    public static void main(String[] args) {
        Developer developer1 = new Developer(1, "jbowo","1234");
        Developer developer2 = new Developer(2, "amy","5545");
        Developer developer3 = new Developer(3, "bob","34t4");
        Developer developer4 = new Developer(4, "ross","1ht4");

        Project project1 = new Project(101,"Some Project");
        Project project2 = new Project(102,"this project");
        Project project3 = new Project(103,"that Project");
        Project project4 = new Project(104,"tomorrow's Project");

        userRepository.insert(developer1);
        userRepository.insert(developer2);
        userRepository.insert(developer3);
        userRepository.insert(developer4);

        projectRepository.insert(project1);
        projectRepository.insert(project2);
        projectRepository.insert(project3);
        projectRepository.insert(project4);

        // project1 -> dev1, dev3
        // project2 -> dev2, dev3
        // project3 -> dev1, dev2, dev4
        // project4 -> dev2, dev3, dev4

        List<Developer> p1developer = Arrays.asList(developer1, developer3);
        List<Developer> p2developer = Arrays.asList(developer2, developer3);
        List<Developer> p3developer = Arrays.asList(developer1, developer2, developer4);
        List<Developer> p4developer = Arrays.asList(developer2, developer3, developer4);

        project1.setDevelopers(p1developer);
        project2.setDevelopers(p2developer);
        project3.setDevelopers(p3developer);
        project4.setDevelopers(p4developer);

        // dev1 -> proj1, proj3
        // dev2 -> proj2, proj3, proj4
        // dev3 -> proj1, proj2, proj4
        // dev4 -> proj3, proj4

        List<Project> d1Projects = Arrays.asList(project1, project3);
        List<Project> d2Projects = Arrays.asList(project2, project3, project4);
        List<Project> d3Projects = Arrays.asList(project1, project2, project4);
        List<Project> d4Projects = Arrays.asList(project3, project1);

        developer1.setProjectList(d1Projects);
        developer2.setProjectList(d2Projects);
        developer3.setProjectList(d3Projects);
        developer4.setProjectList(d4Projects);

        userRepository.update(developer1);
        userRepository.update(developer2);
        userRepository.update(developer3);
        userRepository.update(developer4);

        projectRepository.update(project1);
        projectRepository.update(project2);
        projectRepository.update(project3);
        projectRepository.update(project4);


    }
}
