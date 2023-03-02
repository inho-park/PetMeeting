package com.daelim.petmeeting.board.pBoard.domain;

import com.daelim.petmeeting.common.domain.BaseTimeEntity;
import com.daelim.petmeeting.pet.domain.Pet;
import com.daelim.petmeeting.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_pboard")
@ToString(exclude = "user")
public class PBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pbid;

    @Column(columnDefinition = "tinyint(1) default 1", name = "pcategory")
    private boolean pCategory;

    @Column(columnDefinition = "bigint default 0", nullable = false)
    private Long likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;

    @Column(length = 45, nullable = false)
    private String title;

    @Column(length = 3000, nullable = false)
    private String content;

    @Column(columnDefinition = "bigint default 0")
    private long view;
}

