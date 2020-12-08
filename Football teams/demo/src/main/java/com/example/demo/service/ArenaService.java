package com.example.demo.service;

import com.example.demo.dto.ArenaDto;
import com.example.demo.handler.ArenaIdAlreadyExistsExceptions;
import com.example.demo.handler.ArenaNotFoundException;
import com.example.demo.handler.TeamNotFoundException;

import java.util.List;

public interface ArenaService {

    ArenaDto createNewArena(ArenaDto arenaDto) throws ArenaIdAlreadyExistsExceptions;
    List<ArenaDto> getAllArenas();
    ArenaDto findByTeamName(String teamName) throws TeamNotFoundException;
    ArenaDto updateArena(Long id,ArenaDto arenaDto) throws ArenaNotFoundException,ArenaIdAlreadyExistsExceptions;
    void deleteArena(Long id) throws ArenaNotFoundException;

}
