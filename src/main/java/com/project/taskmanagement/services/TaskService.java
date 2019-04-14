package com.project.taskmanagement.services;

import com.project.taskmanagement.commands.TaskCommand;
import com.project.taskmanagement.domain.Task;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface TaskService {
    TaskCommand saveTaskCommand(TaskCommand taskCommand);
    void saveTaskDeleted(Task taskDeleted);
    Set<Task> getTasks();
    Task findById(Long id);
    void deleteById(Long id);
}
