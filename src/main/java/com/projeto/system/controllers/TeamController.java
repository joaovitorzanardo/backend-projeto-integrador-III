package com.projeto.system.controllers;

import com.projeto.system.dto.TaskTypeDTO;
import com.projeto.system.dto.TeamDTO;
import com.projeto.system.entities.Team;
import com.projeto.system.services.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveTeam(@Valid @RequestBody TeamDTO teamDTO) {
        teamService.saveTeam(teamDTO);
        return "Equipe Criada com Sucesso!";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateTeam(@Valid @RequestBody TeamDTO teamDTO, @RequestParam Long teamId) {
        teamService.updateTeam(teamDTO, teamId);
        return "Equipe Atualizada!";
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteTeam(@RequestParam Long teamId) {
        teamService.deleteTeam(teamId);
        return "Equipe Excluída!";
    }

    @GetMapping
    public ResponseEntity<Team> getTeamById(@RequestParam Long teamId) {
        Team team = teamService.getTeamById(teamId);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

}
