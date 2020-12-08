package com.example.demo.controller;


import com.example.demo.dto.PlayerDto;
import com.example.demo.service.PlayerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@OpenAPIDefinition
@Tag(name = "Players")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/{teamName}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerDto> addNewPlayer( @PathVariable String teamName, @RequestBody PlayerDto playerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.createNewPlayer(teamName, playerDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PlayerDto>> getAllPlayersForAllTeams(){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getAllPlayersForAllTeams());
    }

    @GetMapping("/{teamName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PlayerDto>> getAllPlayersForTeam(@PathVariable(value = "teamName") String teamName) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getAllPlayersForOneTeam(teamName));
    }

    @GetMapping("/{teamName}/{playerNumber}")
    @ResponseStatus(HttpStatus.OK)
    //@ExceptionHandler(ExceptionHandling.PlayerNotFoundException.class)
    public ResponseEntity<PlayerDto> getOnePlayerForTeam(@PathVariable(value = "teamName") String teamName, @PathVariable Integer playerNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getPlayerByTeamNameAndPlayerNumber(teamName, playerNumber));
    }

    @PutMapping("/{teamName}/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable String teamName, @PathVariable Long id, @RequestBody PlayerDto playerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.updatePlayer(teamName, id, playerDto));
    }

    @DeleteMapping("/{playerName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted player");
    }

}
