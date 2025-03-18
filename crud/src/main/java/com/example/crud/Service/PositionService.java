package com.example.crud.Service;

import com.example.crud.Config.PositionMapper;
import com.example.crud.Dto.PositionDto.AddPositionDto;
import com.example.crud.Dto.PositionDto.PositionDto;
import com.example.crud.Entity.Position;
import com.example.crud.Repository.PositionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionService {
    private final ModelMapper mapper;
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository, ModelMapper mapper) {
        this.positionRepository = positionRepository;
        this.mapper = mapper;
    }

    public List<PositionDto> getAllPostions() {
        List<Position> position = positionRepository.findAll();
        return position.stream().map(PositionMapper::toDTO).collect(Collectors.toList());
    }

    public PositionDto getById(int id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return PositionMapper.toDTO(position);
    }

    public List<PositionDto> getByTitle(String name) {
        List<Position> position = positionRepository.findByTitleContaining(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return position.stream().map(PositionMapper::toDTO).collect(Collectors.toList());
    }

    public Position addPosition(AddPositionDto dto) {
        Position position = mapper.map(dto, Position.class);
        return positionRepository.save(position);
    }

    public Position updatePosition(int id, AddPositionDto dto) {
        return positionRepository.findById(id).map(position -> {
            mapper.map(dto, position);
            return positionRepository.save(position);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Position delete(int id) {
        positionRepository.deleteById(id);
        return null;
    }

    public Position delete() {
        positionRepository.deleteAll();
        return null;
    }
}
