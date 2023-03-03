package com.daelim.petmeeting.board.cBoard.cContoller.repository;


import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CBoardRepository extends JpaRepository<CBoard, Long> {

    @Query("select cb, u from CBoard cb left join cb.user u where cb.cbid =:cbid")
    Object getBoardWithWriter(@Param("cbid") Long cbid);

    @Query("SELECT cb, cr FROM CBoard cb LEFT JOIN CReply cr ON cr.cBoard = cb WHERE cb.cbid = :cbid")
    List<Object[]> getBoardWithReply(@Param("cbid") Long cbid);

    @Query(value ="SELECT cb, u, count(cr) " +
            " FROM CBoard cb " +
            " LEFT JOIN cb.user u " +
            " LEFT JOIN CReply cr ON cr.cBoard = cb " +
            " GROUP BY cb",
            countQuery ="SELECT count(cb) FROM CBoard cb")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);


    @Query("SELECT cb, u, count(cr) " +
            " FROM CBoard cb LEFT JOIN cb.user u " +
            " LEFT OUTER JOIN CReply cr ON cr.cBoard = cb" +
            " WHERE cb.cbid = :cbid")
    Object getCBoardByCbid(@Param("cbid") Long cbid);


}
