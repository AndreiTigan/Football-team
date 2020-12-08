package com.example.demo.mapper;

import com.example.demo.dto.TeamDto;
import com.example.demo.entityDao.Team;

import java.util.List;
import java.util.stream.Collectors;


public class TeamMapper {
    public TeamMapper() {
    }

    public static List<TeamDto> toTeamDtoList(final List<Team> teams) {
        return teams.stream().map(TeamMapper::toTeamDto).collect(Collectors.toList());
    }

    public static TeamDto toTeamDto(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName());
        teamDto.setTrophies(team.getTrophies());
        teamDto.setFoundedDate(team.getFoundedDate());
        return teamDto;
    }

    public static Team toTeamDao(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());
        team.setTrophies(teamDto.getTrophies());
        team.setFoundedDate(teamDto.getFoundedDate());
        return team;
    }

   /* public static TeamDto toTeamAndPLayerDto(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName());
        teamDto.setTrophies(team.getTrophies());
        teamDto.setFoundedDate(team.getFoundedDate());
        teamDto.setPlayerDtos(team.getPlayers());
        return teamDto;
    }*/
}
