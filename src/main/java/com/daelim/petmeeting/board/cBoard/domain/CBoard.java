package com.daelim.petmeeting.board.cBoard.domain;

import com.daelim.petmeeting.board.domain.BaseBoard;
import com.daelim.petmeeting.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_cboard")
@ToString(exclude = "user")
public class CBoard extends BaseBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cbid;

    @Column(length = 45, nullable = false, name = "ccategory")
    private String cCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
