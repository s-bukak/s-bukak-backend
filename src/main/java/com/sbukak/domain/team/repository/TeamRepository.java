package com.sbukak.domain.team.repository;

import com.sbukak.global.enums.SportType;
import com.sbukak.domain.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAllBySportType(SportType sportType);
}
