package com.example.demo.entityDao.repository;

import com.example.demo.entityDao.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {

    Player findByPosition(String position);

    Optional<Player> findByPlayerNumber(Integer playerNumber);

    Player findByTeamNameAndPlayerNumber(String teamName, Integer playerNumber);

    Optional<Object> findByName(String name);
}
