package com.innova.innova.service;

import com.innova.innova.Repository.UserRepository;
import com.innova.innova.document.UserDocument;
import com.innova.innova.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        final UserDocument user = this.userRepository.findById(id)
                .orElseThrow(null);
        return this.toDto(user);
    }

    public UserDto save(final UserDto user) {
        final UserDocument userEntity = this.toDocument(user);
        userEntity.setDate(new Date());
        final UserDocument saveEntity = this.userRepository.save(userEntity);
        return this.toDto(saveEntity);
    }

    public UserDto update(final String id, final UserDto userDto) {
        final UserDocument userDocument = this.userRepository.findById(id)
                .orElseThrow(null);
        userDocument.setName(userDto.getName());
        final UserDocument saveDocument = this.userRepository.save(userDocument);
        return this.toDto(saveDocument);
    }

    public void delete(final String id) {
        final UserDocument userDocument = this.userRepository.findById(id)
                .orElseThrow(null);
        this.userRepository.delete(userDocument);
        //this.userRepository.deleteById(id);
    }

    private UserDto toDto(final UserDocument document) {
        final UserDto dto = new UserDto();
        dto.setId(document.getId());
        dto.setName(document.getName());
        return dto;
    }

    private UserDocument toDocument(final UserDto dto) {
        final UserDocument entity = new UserDocument();
        entity.setName(dto.getName());
        return entity;
    }

}
