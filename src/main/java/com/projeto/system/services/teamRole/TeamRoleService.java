package com.projeto.system.services.teamRole;

import com.projeto.system.dto.TeamRoleDTO;
import com.projeto.system.entities.TeamRole;

import java.util.List;

public interface TeamRoleService {

    public TeamRole saveTeamRole(TeamRoleDTO teamRoleDTO);
    public List<TeamRole> getAllTeamRoles();

}
