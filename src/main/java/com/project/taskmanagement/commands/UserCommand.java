package com.project.taskmanagement.commands;


import com.project.taskmanagement.domain.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
public class UserCommand {

    private Long id;
    private String role;
    private String name;

    private Set<Task> tasks;


}
