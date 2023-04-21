package com.projeto.system.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamMemberDTO {

    private Long teamId;
    private List<Long> users;

}
