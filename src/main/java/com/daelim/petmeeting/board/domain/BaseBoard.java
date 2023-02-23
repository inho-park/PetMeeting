package com.daelim.petmeeting.board.domain;


import com.daelim.petmeeting.common.domain.BaseTimeEntity;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseBoard extends BaseTimeEntity {

    @Column(length = 3000, nullable = false)
    private String content;

    @Column(columnDefinition = "bigint default 0")
    private long view;
}
