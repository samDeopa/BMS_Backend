package com.backend.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private  String location;

    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    List<ShowEntity> listOfShowEntities;

    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    List<TheaterSeatEntity> listOfTheaterSeatEntities;

    public TheaterEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
