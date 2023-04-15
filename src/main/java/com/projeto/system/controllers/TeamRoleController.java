package com.projeto.system.controllers;

import com.projeto.system.dto.TeamRoleDTO;
import com.projeto.system.entities.TeamRole;
import com.projeto.system.services.teamRole.TeamRoleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "team-role")
public class TeamRoleController {

    @Autowired
    private TeamRoleServiceImpl teamRoleService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TeamRole> saveTeamRole(@Valid @RequestBody TeamRoleDTO teamRoleDTO) {
        TeamRole newTeamRole = teamRoleService.saveTeamRole(teamRoleDTO);
        return new ResponseEntity<TeamRole>(newTeamRole, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TeamRole> getAllTeamRoles() {
        return teamRoleService.getAllTeamRoles();
    }

}
