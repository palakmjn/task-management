package com.project.taskmanagement.services;

import com.project.taskmanagement.commands.UserCommand;
import com.project.taskmanagement.domain.User;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    User findById(Long id);
    UserCommand saveUserCommand(UserCommand userCommand);
    void deleteById(Long id);
    Set<User> getUsers();

}
