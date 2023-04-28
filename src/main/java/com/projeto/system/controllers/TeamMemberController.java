package com.projeto.system.controllers;

import com.projeto.system.dto.TeamMemberDTO;
import com.projeto.system.services.TeamMemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "team-member")
public class TeamMemberController {

    @Autowired
    TeamMemberService teamMemberService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String saveTeamMembers(@Valid @RequestBody TeamMemberDTO teamMemberDTO) {
        teamMemberService.saveTeamMembers(teamMemberDTO);
        return "Membro da Equipe Cadastrado com Sucesso!";
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteTeamMember(@RequestParam Long teamMemberId) {
        teamMemberService.deleteTeamMember(teamMemberId);
        return "Membro da Equipe Excluído!";
    }

}
