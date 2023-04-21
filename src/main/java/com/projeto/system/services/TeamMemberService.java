package com.projeto.system.services;

import com.projeto.system.dto.TeamMemberDTO;
import com.projeto.system.entities.Team;
import com.projeto.system.entities.TeamMember;
import com.projeto.system.entities.User;
import com.projeto.system.repositories.TeamMemberRepository;
import com.projeto.system.repositories.TeamRepository;
import com.projeto.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamMemberService {

    @Autowired
    TeamMemberRepository teamMemberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    public List<TeamMember> saveTeamMembers(TeamMemberDTO teamMemberDTO) {
        Team team = teamRepository.findTeamByTeamId(teamMemberDTO.getTeamId());
        List<TeamMember> teamMembers = new ArrayList<>();
        for (Long userId: teamMemberDTO.getUsers()) {
            User user = userRepository.findUserByUserId(userId);
            TeamMember teamMember = TeamMember.builder()
                    .user(user)
                    .team(team)
                    .build();
            teamMemberRepository.save(teamMember);
            teamMembers.add(teamMember);
        }
        return teamMembers;
    }

}
