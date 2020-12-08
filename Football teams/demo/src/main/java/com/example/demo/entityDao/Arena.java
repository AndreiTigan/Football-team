package com.example.demo.entityDao;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="ARENAS")

public class Arena {
    @Id
    @Column(name="ID_ARENAS")
    @GeneratedValue(strategy =SEQUENCE, generator ="arena_sequence_generator")
    @SequenceGenerator(name="arena_sequence_generator",sequenceName = "ARENA_SEQUENCE", allocationSize = 1)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CAPACITY")
    private Long capacity;

    @OneToOne
    private Team team;

    public Arena(){

    }

    public Arena(Long id, String name, Long capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arena arena = (Arena) o;
        return Objects.equals(id, arena.id) &&
                Objects.equals(name, arena.name) &&
                Objects.equals(capacity, arena.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity);
    }

}
