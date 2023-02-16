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

    @Column(length = 3000)
    private String content;

    // file 경로를 달아주는 String 을 만들고 나니 AWS S3로 file 의 경로를 어떻게 받아올 수 있는지
    // 찾아볼 필요가 있다고 느낌 ( 경우에 따라 attach 파일 테이블을 따로 생성해야할 수 있음 )
    @Column(length = 100)
    private String file;

    @Column(columnDefinition = "default 0")
    private int view;
}
