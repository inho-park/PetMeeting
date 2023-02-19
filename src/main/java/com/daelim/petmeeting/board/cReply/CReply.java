package com.daelim.petmeeting.board.cReply;

import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import com.daelim.petmeeting.board.domain.BaseReply;
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
public class CReply extends BaseReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crid;

    @ManyToOne(fetch = FetchType.LAZY)
    private CBoard tbl_cboard;

    @ManyToOne(fetch = FetchType.LAZY)
    private User tbl_user;
}
