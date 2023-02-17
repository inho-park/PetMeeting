package com.daelim.petmeeting.board.cBoard.domain;

import com.daelim.petmeeting.board.domain.BaseBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "tbl_cboard")
@NoArgsConstructor
@AllArgsConstructor
public class CBoard extends BaseBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cbid;

    @Column(columnDefinition = "default 0", nullable = false)
    private int view;

}
