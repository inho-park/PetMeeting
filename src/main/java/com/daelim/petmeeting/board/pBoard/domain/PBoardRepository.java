package com.daelim.petmeeting.board.pBoard.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PBoardRepository extends JpaRepository<PBoard, Long> {
    @Query(value = "select pb from PBoard pb where pb.pCategory =: pCategory"
            , countQuery = "select count(pb) from PBoard pb")
    Page<Object[]> findByPCategory(@Param("category") boolean category, Pageable pageable);

}
