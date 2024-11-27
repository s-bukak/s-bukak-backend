package com.sbukak.domain.message.repository;

import com.sbukak.domain.message.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByTeamId(Long teamId);
    @Query("SELECT m FROM Message m WHERE (:teamId = 0 AND m.team IS NULL) OR (m.team.id = :teamId)")
    List<Message> findByTeamIdOrNull(@Param("teamId") Long teamId);
}
