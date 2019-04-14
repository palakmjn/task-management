package com.project.taskmanagement.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Task> tasks;

    public void setId(Long id){
        this.id=id;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getRole(){
        return role;
    }
    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setTasks(Set<Task> tasks){
        this.tasks=tasks;
    }
    public Set<Task> getTasks(){
        return tasks;
    }


}
