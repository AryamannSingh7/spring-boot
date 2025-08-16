package com.aryamann.Engineer;


import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table
public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String techStack;

    public Engineer() {
    }

    public Engineer( Integer id, String name, String techStack) {
        this.name = name;
        this.techStack = techStack;
        Id = id;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", techStack='" + techStack + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return Objects.equals(Id, engineer.Id) && Objects.equals(name, engineer.name) && Objects.equals(techStack, engineer.techStack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, techStack);
    }
}
