package com.project.taskmanagement.services;

import com.project.taskmanagement.commands.UserCommand;
import com.project.taskmanagement.converters.UserCommandToUser;
import com.project.taskmanagement.converters.UserToUserCommand;
import com.project.taskmanagement.domain.User;
import com.project.taskmanagement.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserCommandToUser userCommandToUser;
    private UserToUserCommand userToUserCommand;

    public UserServiceImpl(UserRepository userRepository,UserCommandToUser userCommandToUser,
                           UserToUserCommand userToUserCommand){
        this.userRepository=userRepository;
        this.userCommandToUser=userCommandToUser;
        this.userToUserCommand=userToUserCommand;
    }
    @Override
    public Set<User> getUsers() {
       Set<User> users=new LinkedHashSet<>();
       userRepository.findAll().iterator().forEachRemaining(users::add);
       return users;
    }

    @Override
    public User findById(Long id) {
        Optional<User> users=userRepository.findById(id);
        if(!users.isPresent()){
            throw new RuntimeException("no id");
        }
        return users.get();
    }

    @Override
    public UserCommand saveUserCommand(UserCommand userCommand) {
        User detached=userCommandToUser.convert(userCommand);
        User saved=userRepository.save(detached);
        return userToUserCommand.convert(saved);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
