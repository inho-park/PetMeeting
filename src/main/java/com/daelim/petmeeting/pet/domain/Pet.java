package com.daelim.petmeeting.pet.domain;


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
@Table(name = "tbl_pet")
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(length = 45, name = "petname", nullable = false)
    private String petName;

    @Column(name = "petweight", nullable = false)
    private float petWeight;

    @Column(length = 45, name = "petspecies", nullable = false)
    private String petSpecies;

    @Column(name = "petage", nullable = false)
    private int petAge;

    @Column(length = 100, nullable = false)
    private String petnallity;

    @Column(length = 100, name = "petphoto", nullable = false)
    private String petPhoto;

    // foreign key 로 tbl_user 의 PK 값을 이용해 조회할 경우를 대비해 uid 를
    // add constraint 해준 후 사용
    @ManyToOne(fetch = FetchType.LAZY)
    private User tbl_user;

}
