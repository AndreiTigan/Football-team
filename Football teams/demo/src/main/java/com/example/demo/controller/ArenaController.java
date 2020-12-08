package com.example.demo.controller;

import com.example.demo.dto.ArenaDto;
import com.example.demo.service.ArenaService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@OpenAPIDefinition
@RequestMapping("/teams")
@Tag(name = "Arenas")

public class ArenaController {

    private ArenaService arenaService;

    @Autowired
    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

  /*  @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ArenaDto> addNewArena(@RequestBody ArenaDto arenaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(arenaService.createNewArena(arenaDto));
    }*/

    @GetMapping("/arenas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ArenaDto>> getAllArenas() {
        return ResponseEntity.status(HttpStatus.OK).body(arenaService.getAllArenas());
    }

    @GetMapping("/{teamName}/arenas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ArenaDto> getArenaById(@PathVariable String teamName) {
        return ResponseEntity.status(HttpStatus.OK).body(arenaService.findByTeamName(teamName));
    }

    /*@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ArenaDto> updateArena(@PathVariable Long id, @RequestBody ArenaDto arenaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(arenaService.updateArena(id, arenaDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteArenaById(@PathVariable Long id) {
        arenaService.deleteArena(id);
    }
*/

}
