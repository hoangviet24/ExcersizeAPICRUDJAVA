package com.example.crud.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String imgUrl;
    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;
    @JoinColumn(name = "position_id")
    @ManyToOne
    private Position position;
    public Employee(){}
    public Employee(int id, String name, String email, Department department, Position position,String imgUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.position = position;
        this.imgUrl = imgUrl;
    }

    public String getPosition() {
        return position !=null ? position.getTitle() : null;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDepartment() {
        return department != null? department.getTitle():null;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
