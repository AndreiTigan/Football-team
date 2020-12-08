package com.example.demo.service;

import com.example.demo.dto.TeamDto;
import com.example.demo.handler.IdTeamAlreadyExists;
import com.example.demo.handler.TeamNotFoundException;

import java.util.List;

public interface TeamService {
    TeamDto createNewTeam(TeamDto teamDto);
    List<TeamDto> getAllTeams();
    TeamDto getTeamById(Long id) throws TeamNotFoundException;
    TeamDto updateTeam(Long id, TeamDto teamDto) throws TeamNotFoundException, IdTeamAlreadyExists;
    void deleteTeam(Long id) throws TeamNotFoundException;
}
