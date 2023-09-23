package com.pratheek.userinfo.service;

import com.pratheek.userinfo.dto.UserDto;
import com.pratheek.userinfo.entity.User;
import com.pratheek.userinfo.mapper.UserMapper;
import com.pratheek.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDto addUser(UserDto userDto) {
        User savedUser = repository.save(UserMapper.INSTANCE.mapUserDtoToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }

    public ResponseEntity<UserDto> fetchUserById(Integer userId) {
        Optional<User> fetchedUser = repository.findById(userId);
        if(fetchedUser.isPresent())
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(fetchedUser.get()), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
