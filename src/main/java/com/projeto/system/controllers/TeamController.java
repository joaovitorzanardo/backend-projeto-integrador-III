package com.projeto.system.controllers;

import com.projeto.system.dto.TeamDTO;
import com.projeto.system.entities.Team;
import com.projeto.system.services.team.TeamServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "team")
public class TeamController {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> saveTeam(@Valid @RequestBody TeamDTO teamDTO) {
        Team newTeam = teamService.saveTeam(teamDTO);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }

}
