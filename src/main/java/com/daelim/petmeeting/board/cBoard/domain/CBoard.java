package com.daelim.petmeeting.board.cBoard.domain;

import com.daelim.petmeeting.common.domain.BaseTimeEntity;
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
public class CBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cbid;

    @Column(length = 45, nullable = false, name = "ccategory")
    private String cCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(length = 45, nullable = false)
    private String title;

    @Column(length = 3000, nullable = false)
    private String content;

    @Column(columnDefinition = "bigint default 0")
    private long view;
}
