package com.project.taskmanagement.converters;

import com.project.taskmanagement.commands.TaskCommand;
import com.project.taskmanagement.domain.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskCommandToTask implements Converter<TaskCommand,Task> {
    @Override
    public Task convert(TaskCommand source) {
        if(source==null)
            return null;
        Task task=new Task();
        task.setId(source.getId());
        task.setName(source.getTname());
        task.setAssignee(source.getAssignee());
        task.setStart_date(source.getStart_date());
        task.setEnd_date(source.getEnd_date());
        task.setStatus(source.getStatus());
        task.setUser(source.getUser());
        return task;
    }
}
