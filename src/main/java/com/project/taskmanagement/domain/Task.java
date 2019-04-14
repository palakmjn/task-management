package com.project.taskmanagement.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String start_date;
    private String end_date;
    private String assignee;
    private String status;
    private String description;


    @ManyToMany
    private Set<User> user;

    public void setId(Long id){
        this.id=id;
    }
    public void setStart_date(String start_date){
        this.start_date=start_date;
    }
    public String getStart_date(){
        return start_date;
    }
    public void setEnd_date(String end_date){
        this.end_date=end_date;
    }
    public String getEnd_date(){
        return end_date;
    }
    public Long getId(){
        return id;
    }
    public void setName(String tname){
        this.name=tname;
    }
    public String getName(){
        return name;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
    public void setAssignee(String assignee){
        this.assignee=assignee;
    }
    public String getAssignee(){
        return assignee;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Set<User> getUser(){
        return user;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
