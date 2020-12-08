package com.example.demo.entityDao.repository;

import com.example.demo.entityDao.Arena;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArenaRepository extends JpaRepository<Arena,Long> {

    Optional<Arena> findArenaByTeamNameContaining(String teamName);
}
