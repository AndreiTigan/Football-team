package com.example.demo.mapper;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entityDao.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerMapper {

    public PlayerMapper() {
    }

    public static List<PlayerDto> toPlayerDtoList(final List<Player> players) {
        return players.stream().map(PlayerMapper::toPlayerDto).collect(Collectors.toList());
    }


    public static PlayerDto toPlayerDto(Player player) {
        //din entity in dto
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(player.getId());
        playerDto.setName(player.getName());
        playerDto.setPosition(player.getPosition());
        playerDto.setBirthDate(player.getBirthDate());
        playerDto.setPlayerNumber(player.getPlayerNumber());
        return playerDto;
    }


    public static Player toPlayerDao(PlayerDto playerDto) {
        //din dto in entity
        Player player = new Player();
        player.setId(playerDto.getId());
        player.setName(playerDto.getName());
        player.setPosition(playerDto.getPosition());
        player.setBirthDate(playerDto.getBirthDate());
        player.setPlayerNumber(playerDto.getPlayerNumber());
        return player;
    }

    /*public static PlayerDto toTeamPlayerDto(Team team, List<Player> players) {
        TeamDto teamDto = new TeamDto();
        List<PlayerDto> playerDto = new ArrayList<>();
        playerDto = players.stream().map(PlayerMapper::toPlayerDto).collect(Collectors.toList());
        team.setPlayers(playerDto.get().get);
    }*/




}
