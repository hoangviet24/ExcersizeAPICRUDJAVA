package com.example.crud.Dto.PositionDto;

public class AddPositionDto {
    private String title;

    public AddPositionDto() {
    }

    public AddPositionDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
