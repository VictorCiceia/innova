package com.innova.innova.service;

import com.innova.innova.Entity.UserEntity;
import com.innova.innova.Repository.UserRepository;
import com.innova.innova.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll() {
        return this.userRepository.findAll()
                .stream().map(this::toDto)
                .collect(Collectors.toList());
    }

    public UserDto findById(final String id) {
        final UserEntity user = this.userRepository.findById(id)
                .orElseThrow(null);
        return this.toDto(user);
    }

    public UserDto save(final UserDto user) {
        final UserEntity userEntity = this.toDocument(user);
        final UserEntity saveEntity = this.userRepository.save(userEntity);
        return this.toDto(saveEntity);
    }

    public UserDto update(final String id, final UserDto userDto) {
        final UserEntity userEntity = this.userRepository.findById(id)
                .orElseThrow(null);
        userEntity.setName(userDto.getName());
        final UserEntity saveDocument = this.userRepository.save(userEntity);
        return this.toDto(saveDocument);
    }

    public void delete(final String id) {
        final UserEntity userEntity = this.userRepository.findById(id)
                .orElseThrow(null);
        this.userRepository.delete(userEntity);
    }

    private UserDto toDto(final UserEntity entity) {
        final UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    private UserEntity toDocument(final UserDto dto) {
        final UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        return entity;
    }

}
