package com.daelim.petmeeting.board.pReply;

import com.daelim.petmeeting.board.domain.BaseReply;
import com.daelim.petmeeting.board.pBoard.domain.PBoard;
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
public class PReply extends BaseReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prid;

    @ManyToOne(fetch = FetchType.LAZY)
    private PBoard tbl_pboard;

    @ManyToOne(fetch = FetchType.LAZY)
    private User tbl_user;
}
