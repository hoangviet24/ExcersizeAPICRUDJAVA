package com.example.crud.Dto.DepartmentDto;

public class AddDepartmentDto {
    private String title;

    public AddDepartmentDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
