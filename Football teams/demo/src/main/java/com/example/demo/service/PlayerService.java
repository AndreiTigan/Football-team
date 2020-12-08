package com.example.demo.service;


import com.example.demo.dto.PlayerDto;
import com.example.demo.handler.IdPlayerAlreadyExist;
import com.example.demo.handler.PlayerNotFoundException;
import com.example.demo.handler.TeamNotFoundException;

import java.util.List;

public interface PlayerService {

    PlayerDto createNewPlayer(String teamName, PlayerDto playerDto) throws TeamNotFoundException, IdPlayerAlreadyExist;

    List<PlayerDto> getAllPlayersForOneTeam(String teamName) throws TeamNotFoundException;

    //PlayerDto getPlayerById(Long id) throws PlayerNotFoundException;

    PlayerDto updatePlayer(String teamName, Long id, PlayerDto playerDto) throws TeamNotFoundException, PlayerNotFoundException, IdPlayerAlreadyExist;

    void deletePlayer(String name) throws PlayerNotFoundException;

    List<PlayerDto> getAllPlayersForAllTeams();

    PlayerDto getPlayerByTeamNameAndPlayerNumber(String teamName, Integer playerNumber) throws TeamNotFoundException;
}
