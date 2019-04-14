package com.project.taskmanagement.controllers;

import com.project.taskmanagement.commands.TaskCommand;
import com.project.taskmanagement.converters.TaskCommandToTask;
import com.project.taskmanagement.domain.Task;
import com.project.taskmanagement.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class TaskController 
{
    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @RequestMapping("task/{id}/show")
    public String showById(@PathVariable String id,Model model){
        model.addAttribute("task",taskService.findById(new Long(id)));

        return "task/show";
    }

    @RequestMapping("tasks/show")
    public String showTasks(Model model){
        model.addAttribute("tasks",taskService.getTasks());
        return "task/list";
    }

    @RequestMapping("/task/new")
    public String createTask(Model model){
        model.addAttribute("task",new TaskCommand());
        return "task/info";
    }

    @RequestMapping(name="task")
    public String saveTask(@ModelAttribute TaskCommand taskCommand){
        TaskCommand saved=taskService.saveTaskCommand(taskCommand);
        return "redirect:task/" + saved.getId() +"/show";
    }

    @RequestMapping("task/{id}/delete")
    public String deleteById(@PathVariable String id,Model model){
        Task taskToDelete=taskService.findById(new Long(id));
        //check return valueeeee??
        taskService.saveTaskDeleted(taskToDelete);
        taskService.deleteById(taskToDelete.getId());

        return "redirect:tasks/show";
    }

    @RequestMapping("task/{id}/update")
    public String updateById(@PathVariable String id,Model model){
        model.addAttribute("task",taskService.findById(new Long(id)));

        return "task/info";
    }

}
