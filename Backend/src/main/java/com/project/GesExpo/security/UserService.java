package com.project.GesExpo.security;

import com.project.GesExpo.dto.UserDto;
import com.project.GesExpo.models.User;
import com.project.GesExpo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public User dtoToUser(UserDto userDto){
        return this.modelMapper.map(userDto, User.class);
    }

    public UserDto userToDto(User user){
        return this.modelMapper.map(user, UserDto.class);
    }

    public UserDto createUser(UserDto userDto){
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }
}
