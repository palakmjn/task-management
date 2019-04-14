package com.project.taskmanagement.commands;

import com.project.taskmanagement.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
public class TaskCommand {
    private Long id;

    private String name;
    private String start_date;
    private String end_date;
    private String assignee;
    private String status;
private String tname;
    private Set<User> user;
}
