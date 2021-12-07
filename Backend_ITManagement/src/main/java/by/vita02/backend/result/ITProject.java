package by.vita02.backend.result;

import by.vita02.backend.enums.ProjectType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ITProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ProjectType projectType;
    private int costOfConventionalUnit;
    private String nameOfConventionalUnit;

    public ITProject(ProjectType projectType, int costOfConventionalUnit, String nameOfConventionalUnit) {
        this.projectType = projectType;
        this.costOfConventionalUnit = costOfConventionalUnit;
        this.nameOfConventionalUnit = nameOfConventionalUnit;
    }

    public ITProject() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public int getCostOfConventionalUnit() {
        return costOfConventionalUnit;
    }

    public void setCostOfConventionalUnit(int costOfConventionalUnit) {
        this.costOfConventionalUnit = costOfConventionalUnit;
    }

    public String getNameOfConventionalUnit() {
        return nameOfConventionalUnit;
    }

    public void setNameOfConventionalUnit(String nameOfConventionalUnit) {
        this.nameOfConventionalUnit = nameOfConventionalUnit;
    }
}