package com.daelim.petmeeting.board.cReply.domain;

import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import com.daelim.petmeeting.common.domain.BaseTimeEntity;
import com.daelim.petmeeting.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "tbl_creply")
@NoArgsConstructor
@AllArgsConstructor
public class CReply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crid;

    @ManyToOne(fetch = FetchType.LAZY)
    private CBoard cBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(length = 3000, nullable = false)
    private String content;
}
