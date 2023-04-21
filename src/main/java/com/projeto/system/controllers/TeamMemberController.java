package com.projeto.system.controllers;

import com.projeto.system.dto.TeamMemberDTO;
import com.projeto.system.entities.TeamMember;
import com.projeto.system.services.TeamMemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "team-member")
public class TeamMemberController {

    @Autowired
    TeamMemberService teamMemberService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<TeamMember> saveTeamMembers(@Valid @RequestBody TeamMemberDTO teamMemberDTO) {
        return teamMemberService.saveTeamMembers(teamMemberDTO);
    }

}
