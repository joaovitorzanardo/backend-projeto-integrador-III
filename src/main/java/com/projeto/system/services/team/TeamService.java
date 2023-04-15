package com.projeto.system.services.team;

import com.projeto.system.dto.TeamDTO;
import com.projeto.system.entities.Team;

import java.util.List;

public interface TeamService {

    public List<Team> getAllTeams();

    public Team saveTeam(TeamDTO teamDTO);

}
