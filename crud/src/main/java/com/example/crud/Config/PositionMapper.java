package com.example.crud.Config;

import com.example.crud.Dto.PositionDto.PositionDto;
import com.example.crud.Entity.Employee;
import com.example.crud.Entity.Position;

import java.util.stream.Collectors;

public class PositionMapper {
    public static PositionDto toDTO(Position position){
        return new PositionDto(
                position.getId(),
                position.getTitle(),
                position.getEmployees() != null?position.getEmployees().stream().map(Employee::getName).collect(Collectors.toList()):null
        );
    }
}
