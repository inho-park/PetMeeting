package com.daelim.petmeeting.board.pReply.domain;

import com.daelim.petmeeting.board.pBoard.domain.PBoard;
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
@Table(name = "tbl_preply")
@NoArgsConstructor
@AllArgsConstructor
public class PReply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prid;

    @ManyToOne(fetch = FetchType.LAZY)
    private PBoard pBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(length = 3000, nullable = false)
    private String content;
}
