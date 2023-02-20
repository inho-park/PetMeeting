package com.daelim.petmeeting.board.pBoard.domain;

import com.daelim.petmeeting.board.domain.BaseBoard;
import com.daelim.petmeeting.pet.domain.Pet;
import com.daelim.petmeeting.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "tbl_pboard")
@NoArgsConstructor
@AllArgsConstructor
public class PBoard extends BaseBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pbid;

    @Column(columnDefinition = "tinyint(1) default 1", name = "pcategory")
    private boolean pCategory;

    @Column(columnDefinition = "default 0", nullable = false)
    private int view;

    @Column(columnDefinition = "default 0", nullable = false)
    private int like;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;
}

