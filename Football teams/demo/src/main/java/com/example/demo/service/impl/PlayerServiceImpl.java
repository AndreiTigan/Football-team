package com.example.demo.service.impl;


import com.example.demo.dto.PlayerDto;
import com.example.demo.entityDao.Player;
import com.example.demo.entityDao.Team;
import com.example.demo.entityDao.repository.PlayerRepository;
import com.example.demo.entityDao.repository.TeamRepository;
import com.example.demo.handler.IdPlayerAlreadyExist;
import com.example.demo.handler.PlayerNotFoundException;
import com.example.demo.handler.TeamNotFoundException;
import com.example.demo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mapper.PlayerMapper.*;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public PlayerDto createNewPlayer(String teamName, PlayerDto playerDto) throws TeamNotFoundException, IdPlayerAlreadyExist {
        LOGGER.info("Creating Player: {} in {}", playerDto, teamName);
        Team team = teamRepository.findByName(teamName).orElseThrow(() -> new TeamNotFoundException("Team " + teamName + " Not found"));
        Player player = toPlayerDao(playerDto);
        player.setTeam(team);
        playerRepository.save(player);
        return toPlayerDto(player);
    }

    @Override
    public List<PlayerDto> getAllPlayersForOneTeam(String teamName) throws TeamNotFoundException {
        LOGGER.info("Searching for all players by team name. ");
        Team team = teamRepository.findByName(teamName).orElseThrow(() -> new TeamNotFoundException("Team " + teamName + " Not found"));
        //List<Player> players = team.getPlayers();
        return toPlayerDtoList(team.getPlayers());
    }

    @Override
    public List<PlayerDto> getAllPlayersForAllTeams() {
        LOGGER.info("Searching for all players from all teams. ");
        return toPlayerDtoList(playerRepository.findAll());
    }

    @Override
    public PlayerDto getPlayerByTeamNameAndPlayerNumber(String teamName, Integer playerNumber) throws TeamNotFoundException {
        LOGGER.info("Searching for a player by team name and player id. ");
        Team team = teamRepository.findByName(teamName).orElseThrow(() -> new TeamNotFoundException("Team " + teamName + " Not found"));
        Player player = playerRepository.findByPlayerNumber(playerNumber).orElseThrow(() -> new PlayerNotFoundException("Player with number " + playerNumber + " not found"));
        return toPlayerDto(playerRepository.findByTeamNameAndPlayerNumber(team.getName(), player.getPlayerNumber()));
    }


    @Override
    public PlayerDto updatePlayer(String teamName, Long id, PlayerDto playerDto) throws PlayerNotFoundException {
        LOGGER.info("Updating player with id: {},with values:{} in ", id, playerDto, teamName);
        Team team = teamRepository.findByName(teamName).
                orElseThrow(() -> new TeamNotFoundException("Team " + teamName + " Not found"));
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player " + id + " not found"));
        BeanUtils.copyProperties(playerDto, player);
        playerRepository.save(toPlayerDao(playerDto));
        //sursa playerDto, target player
        return toPlayerDto(playerRepository.save(player));
    }

    @Override
    public void deletePlayer(String playerName) throws PlayerNotFoundException {
        LOGGER.info("Deleting player: {}", playerName);
        Object player = playerRepository.findByName(playerName).orElseThrow(() -> new PlayerNotFoundException("Player " + playerName + " not found"));
        playerRepository.delete((Player) player);
    }


}
