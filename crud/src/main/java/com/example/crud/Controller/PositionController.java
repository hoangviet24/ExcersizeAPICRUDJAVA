package com.example.crud.Controller;

import com.example.crud.Dto.PositionDto.AddPositionDto;
import com.example.crud.Dto.PositionDto.PositionDto;
import com.example.crud.Entity.Position;
import com.example.crud.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Position")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/getAll")
    public List<PositionDto> getAll() {
        return positionService.getAllPostions();
    }

    @GetMapping("/getId/{id}")
    public PositionDto getById(@PathVariable int id) {
        return positionService.getById(id);
    }

    @GetMapping("/getName/{name}")
    public List<PositionDto> getByName(@PathVariable String name) {
        return positionService.getByTitle(name);
    }

    @PostMapping("/Post")
    public Position add(@RequestBody AddPositionDto dto) {
        return positionService.addPosition(dto);
    }

    @PutMapping("/Put/{id}")
    public Position update(@PathVariable int id, @RequestBody AddPositionDto dto) {
        return positionService.updatePosition(id, dto);
    }

    @DeleteMapping("/Delete/{id}")
    public Position delete(@PathVariable int id) {
        return positionService.delete(id);
    }

    @DeleteMapping("/Delete")
    public Position delete() {
        return positionService.delete();
    }
}
