package com.project.taskmanagement.services;

import com.project.taskmanagement.commands.TaskCommand;
import com.project.taskmanagement.converters.TaskCommandToTask;
import com.project.taskmanagement.converters.TaskToTaskCommand;
import com.project.taskmanagement.domain.Task;
import com.project.taskmanagement.repositories.DeletedRepository;
import com.project.taskmanagement.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {
   private TaskToTaskCommand taskToTaskCommand;
   private TaskCommandToTask taskCommandToTask;
   private TaskRepository taskRepository;
   private DeletedRepository deletedRepository;

    public TaskServiceImpl(TaskRepository taskRepository,TaskToTaskCommand taskToTaskCommand,
                           TaskCommandToTask taskCommandToTask,DeletedRepository deletedRepository){
        this.taskRepository=taskRepository;
        this.taskToTaskCommand=taskToTaskCommand;
        this.taskCommandToTask=taskCommandToTask;
        this.deletedRepository=deletedRepository;
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> task=taskRepository.findById(id);
        return task.get();
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }


    @Override
    public TaskCommand saveTaskCommand(TaskCommand taskCommand) {
       Task detached=taskCommandToTask.convert(taskCommand);
       Task saved=taskRepository.save(detached);
       return taskToTaskCommand.convert(saved);
    }

    @Override
    public void saveTaskDeleted(Task taskDeleted) {
        deletedRepository.save(taskDeleted);
    }

    @Override
    public Set<Task> getTasks() {
        Set<Task> taskSet=new LinkedHashSet<>();
        //check?
        taskRepository.findAll().iterator().forEachRemaining(taskSet::add);
        return taskSet;
    }


}
