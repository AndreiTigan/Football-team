package com.example.demo.service.impl;

import com.example.demo.dto.TeamDto;
import com.example.demo.entityDao.Team;
import com.example.demo.entityDao.repository.TeamRepository;
import com.example.demo.handler.IdTeamAlreadyExists;
import com.example.demo.handler.TeamNotFoundException;
import com.example.demo.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.mapper.TeamMapper.*;

@Service
public class TeamServiceImpl implements TeamService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamServiceImpl.class);

    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public TeamDto createNewTeam(TeamDto teamDto) throws IdTeamAlreadyExists {
        LOGGER.info("Creating team: {}", teamDto);
        Optional<Team> team1 = teamRepository.findById(teamDto.getId());
        if(team1.isPresent()) {
            throw new IdTeamAlreadyExists("The team with id " + team1.get().getId() + " already exists!");
        }
        else {
            Team team = toTeamDao(teamDto);
            teamRepository.save(team);
            return toTeamDto(team);
        }
    }

    @Override
    public List<TeamDto> getAllTeams() throws TeamNotFoundException{
        LOGGER.info("Searching for all teams.");
        return toTeamDtoList(teamRepository.findAll());
    }

    @Override
    public TeamDto getTeamById(Long id) throws TeamNotFoundException {
        LOGGER.info("Searching for team with id: {}", id);
        return toTeamDto(teamRepository.findById(id).orElseThrow(()->new TeamNotFoundException("Team " + id + " not found")));
    }

    @Override
    public TeamDto updateTeam(Long id, TeamDto teamDto) throws TeamNotFoundException {
        LOGGER.info("Updating team with id: {}, with values: {}", id, teamDto);
        Team team = teamRepository.findById(id).orElseThrow(()->new TeamNotFoundException("Team " + id + " not found"));
        BeanUtils.copyProperties(teamDto, team);
        return toTeamDto(teamRepository.save(team));
    }

    @Override
    public void deleteTeam(Long id) throws TeamNotFoundException {
        LOGGER.info("Deleting team with id: {id}",id);
        Team team = teamRepository.findById(id).orElseThrow(()->new TeamNotFoundException("Team " + id + " not found"));
        teamRepository.deleteById(id);
    }
}
