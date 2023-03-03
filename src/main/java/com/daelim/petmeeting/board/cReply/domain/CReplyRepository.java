package com.daelim.petmeeting.board.cReply.domain;

import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import com.daelim.petmeeting.board.pBoard.domain.PBoard;
import com.daelim.petmeeting.board.pReply.domain.PReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CReplyRepository extends JpaRepository<com.daelim.petmeeting.board.cReply.domain.CReply, Long> {
    @Modifying
    @Query("delete from CReply cr where cr.cBoard.cbid =:cbid ")
    void deleteBycbid(@Param("cbid") Long cbid);

    List<CReply> getCRepliesByCBoardOOrderByCrid(CBoard cboard);
}

