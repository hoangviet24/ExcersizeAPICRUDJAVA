package com.example.crud.Dto.PositionDto;

import java.util.List;

public class PositionDto {
    private int id;
    private String title;
    private List<String> nameEmployees;

    public PositionDto() {
    }

    public PositionDto(int id, String title, List<String> nameEmployees) {
        this.id = id;
        this.title = title;
        this.nameEmployees = nameEmployees;
    }

    public List<String> getNameEmployees() {
        return nameEmployees;
    }

    public void setNameEmployees(List<String> nameEmployees) {
        this.nameEmployees = nameEmployees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
