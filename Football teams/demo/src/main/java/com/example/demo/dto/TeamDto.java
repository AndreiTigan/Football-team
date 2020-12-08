package com.example.demo.dto;


import java.time.LocalDate;


public class TeamDto {
    private Long id;
    private String name;
    private Integer trophies;
    private LocalDate foundedDate;


    public TeamDto() {
    }

    public TeamDto(Long id, String name, Integer trophies, LocalDate foundedDate) {
        this.id = id;
        this.name = name;
        this.trophies = trophies;
        this.foundedDate = foundedDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTrophies() {
        return trophies;
    }

    public void setTrophies(Integer trophies) {
        this.trophies = trophies;
    }

    public LocalDate getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(LocalDate foundedDate) {
        this.foundedDate = foundedDate;
    }

}
