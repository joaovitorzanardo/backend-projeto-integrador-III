package com.projeto.system.repositories;

import com.projeto.system.entities.TeamRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRoleRepository extends JpaRepository<TeamRole, Long> {
}
