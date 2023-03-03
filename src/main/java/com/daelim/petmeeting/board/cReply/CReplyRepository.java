package com.daelim.petmeeting.board.cReply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CReplyRepository extends JpaRepository<CReply, Long> {
    @Modifying
    @Query("delete from CReply cr where cr.cBoard.cbid =:cbid ")
    void deleteBycbid(@Param("cbid") Long cbid);
}
