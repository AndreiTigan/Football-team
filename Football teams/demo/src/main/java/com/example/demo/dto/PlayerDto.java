package com.example.demo.dto;

import java.time.LocalDate;

public class PlayerDto {

    private Long id;
    private String name;
    private String position;
    private LocalDate birthDate;
    private Integer playerNumber;

    public PlayerDto() {
    }

    public PlayerDto(String name, String position, LocalDate birthDate, Integer playerNumber) {
        this.name = name;
        this.position = position;
        this.birthDate = birthDate;
        this.playerNumber = playerNumber;
    }

    public PlayerDto(Long id, String name, String position, LocalDate birthDate, Integer playerNumber) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.birthDate = birthDate;
        this.playerNumber = playerNumber;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }
}
