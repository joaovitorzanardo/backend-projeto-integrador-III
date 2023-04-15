package com.projeto.system.services.teamRole;

import com.projeto.system.dto.TeamRoleDTO;
import com.projeto.system.entities.TeamRole;
import com.projeto.system.repositories.TeamRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamRoleServiceImpl implements TeamRoleService {

    @Autowired
    private TeamRoleRepository teamRoleRepository;

    @Override
    public TeamRole saveTeamRole(TeamRoleDTO teamRoleDTO) {
        return teamRoleRepository.save(new TeamRole(teamRoleDTO.getDescription()));
    }

    @Override
    public List<TeamRole> getAllTeamRoles() {
        return teamRoleRepository.findAll();
    }
}
