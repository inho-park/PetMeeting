package com.daelim.petmeeting.board.pReply.domain;

import com.daelim.petmeeting.board.pBoard.domain.PBoard;
import com.daelim.petmeeting.board.pReply.domain.PReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PReplyRepository extends JpaRepository<PReply, Long> {

    @Modifying
    @Query("DELETE FROM PReply r WHERE r.pBoard.pbid =:bno")
    void deleteByBno(Long bno);

    List<PReply> getPRepliesByPBoardOOrderByPrid(PBoard board);
}
