package com.example.crud.Service;

import com.example.crud.Config.PositionMapper;
import com.example.crud.Dto.PositionDto.PositionDto;
import com.example.crud.Entity.Position;
import com.example.crud.Repository.PositionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionService {
    private PositionRepository positionRepository;
    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }
    public List<PositionDto> getAllPostions(){
        List<Position> position = positionRepository.findAll();
        return position.stream().map(PositionMapper::toDTO).collect(Collectors.toList());
    }
}
