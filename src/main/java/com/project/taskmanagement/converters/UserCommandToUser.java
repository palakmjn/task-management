package com.project.taskmanagement.converters;

import com.project.taskmanagement.commands.UserCommand;
import com.project.taskmanagement.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserCommandToUser implements Converter<UserCommand,User> {


    @Override
    public User convert(UserCommand source) {
        if(source==null){
            return null;}
            User user=new User();
            user.setId(source.getId());
            user.setName(source.getName());
            user.setRole(source.getRole());
            user.setTasks(source.getTasks());
            return user;

    }
}
