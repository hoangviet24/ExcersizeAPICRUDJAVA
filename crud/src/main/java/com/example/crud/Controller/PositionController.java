package com.example.crud.Controller;

import com.example.crud.Dto.PositionDto.PositionDto;
import com.example.crud.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Postition")
public class PositionController {
    private PositionService positionService;
    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    @GetMapping()
    public List<PositionDto> getAll(){
        return positionService.getAllPostions();
    }
}
