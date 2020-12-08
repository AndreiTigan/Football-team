package com.example.demo.service.impl;

import com.example.demo.dto.ArenaDto;
import com.example.demo.entityDao.Arena;
import com.example.demo.entityDao.repository.ArenaRepository;
import com.example.demo.entityDao.repository.TeamRepository;
import com.example.demo.handler.ArenaIdAlreadyExistsExceptions;
import com.example.demo.handler.ArenaNotFoundException;
import com.example.demo.handler.TeamNotFoundException;
import com.example.demo.service.ArenaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.mapper.ArenaMapper.from;

@Service

public class ArenaServiceImpl implements ArenaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArenaServiceImpl.class);

    private ArenaRepository arenaRepository;
    private TeamRepository teamRepository;

    @Autowired
    public ArenaServiceImpl(ArenaRepository arenaRepository, TeamRepository teamRepository) {
        this.arenaRepository = arenaRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public ArenaDto createNewArena(ArenaDto arenaDto) {
        LOGGER.info("Create Arena: {}", arenaDto);

        Optional<Arena> arena = arenaRepository.findById(arenaDto.getId());

        if (arena.isPresent()) {
            throw new ArenaIdAlreadyExistsExceptions("The Arena with id " + arena.get().getId() + " already exists");
        } else {
            Arena arenaChecked = from(arenaDto);
            arenaRepository.save(arenaChecked);
            return from(arenaChecked);
        }
    }

    @Override
    public List<ArenaDto> getAllArenas() {
        LOGGER.info("Retrieving all arenas .");
        return from(arenaRepository.findAll());
    }

    @Override
    public ArenaDto findByTeamName(String teamName) throws TeamNotFoundException {
        LOGGER.info("Searching for Arena with name: {}", teamName);
        //Team team = teamRepository.findByName(teamName).orElseThrow(()->new TeamNotFoundException("Team " + teamName + " Not found"));
        return from(arenaRepository.findArenaByTeamNameContaining(teamName)
                .orElseThrow(() -> new ArenaNotFoundException("Arena with name " + teamName + " was not Found")));
    }

    @Override
    public ArenaDto updateArena(Long id, ArenaDto arenaDto) throws ArenaNotFoundException, ArenaIdAlreadyExistsExceptions {
        LOGGER.info("Updating player with Id: {},with values: {}", id, arenaDto);
        Optional<Arena> arena = arenaRepository.findById(id);
        if (arena.isPresent()) {
            new ArenaIdAlreadyExistsExceptions("Arena Id " + id + " already exists");
        } else if (!arena.isPresent()) {
            new ArenaNotFoundException("Arena id " + id + " not Found");
        }
        Arena arenaChecked = from(arenaDto);
        arenaRepository.save(arenaChecked);
        return from(arenaChecked);
    }

    @Override
    public void deleteArena(Long id) throws ArenaNotFoundException {
        LOGGER.info("Delete Arena with Id: {}", id);
        ArenaDto arenaDto = from(arenaRepository.findById(id)
                .orElseThrow(() -> new ArenaNotFoundException("Arena with id " + id + " was not Found")));
        arenaRepository.deleteById(arenaDto.getId());
    }
}
