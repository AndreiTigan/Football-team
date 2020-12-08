package com.example.demo.dto;

public class ArenaDto {

    private Long id;
    private String name;
    private Long capacity;
    private TeamDto teamDto;

    public ArenaDto() {
    }

    public ArenaDto(Long id, String name, Long capacity, TeamDto teamDto) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.teamDto = teamDto;
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

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public TeamDto getTeamDto() {
        return teamDto;
    }

    public void setTeamDto(TeamDto teamDto) {
        this.teamDto = teamDto;
    }
}
