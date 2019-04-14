package com.project.taskmanagement.converters;

import com.project.taskmanagement.commands.TaskCommand;
import com.project.taskmanagement.domain.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class TaskToTaskCommand implements Converter<Task,TaskCommand> {

    @Override
    public TaskCommand convert(Task source) {
        if(source==null)
            return null;
        TaskCommand command=new TaskCommand();
        command.setId(source.getId());
        command.setTname(source.getName());
        command.setAssignee(source.getAssignee());
        command.setStart_date(source.getStart_date());
        command.setEnd_date(source.getEnd_date());
        command.setStatus(source.getStatus());
        command.setUser(source.getUser());
       return command;
    }
}
