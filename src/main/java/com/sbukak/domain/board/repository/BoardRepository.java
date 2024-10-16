package com.sbukak.domain.board.repository;

import com.sbukak.domain.board.domain.Board;
import com.sbukak.domain.board.enums.BoardType;
import com.sbukak.global.enums.SportType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b from Board b where b.sportType = :sportType and b.boardType = :boardType and b.user.id = :userId " +
        "and (b.title like CONCAT('%',:query,'%') or b.content like CONCAT('%',:query,'%'))")
    Page<Board> findAllBySportTypeAndBoardTypeAndUserIdAndTitleOrContentContaining(
        @Param("query") String query,
        @Param("sportType") SportType sportType,
        @Param("boardType") BoardType boardType,
        Long userId,
        Pageable pageable
    );

    @Query("select b from Board b where b.sportType = :sportType and b.boardType = :boardType " +
        "and (b.title like CONCAT('%',:query,'%') or b.content like CONCAT('%',:query,'%'))")
    Page<Board> findAllBySportTypeAndBoardTypeAndTitleOrContentContaining(
        @Param("query") String query,
        @Param("sportType") SportType sportType,
        @Param("boardType") BoardType boardType,
        Pageable pageable
    );

    Page<Board> findAllBySportTypeAndBoardTypeAndUserId(
        SportType sportType, BoardType boardType, Long userId, Pageable pageable
    );

    Page<Board> findAllBySportTypeAndBoardType(SportType sportType, BoardType boardType, Pageable pageable);
}
