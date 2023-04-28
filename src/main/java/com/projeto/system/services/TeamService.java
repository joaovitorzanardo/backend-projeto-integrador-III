package com.projeto.system.services;

import com.projeto.system.dto.TeamDTO;
import com.projeto.system.entities.Team;
import com.projeto.system.entities.TeamMember;
import com.projeto.system.entities.User;
import com.projeto.system.repositories.TeamRepository;
import com.projeto.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void saveTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setDescription(teamDTO.getDescription());
        if (teamDTO.getTeamMembers() != null && !teamDTO.getTeamMembers().isEmpty()) {
            List<TeamMember> teamMembers = new ArrayList<>();
            for (Long userId: teamDTO.getTeamMembers()) {
                User user = userRepository.findUserByUserId(userId);
                TeamMember teamMember = TeamMember.builder()
                        .team(team)
                        .user(user)
                        .build();
                teamMembers.add(teamMember);
            }
            team.setTeamMembers(teamMembers);
        }
        teamRepository.save(team);
    }

    public void updateTeam(TeamDTO teamDTO, Long teamId) {
        Team team = teamRepository.findTeamByTeamId(teamId);
        team.setName(teamDTO.getName());
        team.setDescription(teamDTO.getDescription());
        teamRepository.save(team);
    }

    public void deleteTeam(Long teamId) {
        Team team = teamRepository.findTeamByTeamId(teamId);
        teamRepository.delete(team);
    }

    public Team getTeamById(Long teamId) {
        return teamRepository.findTeamByTeamId(teamId);
    }
}
