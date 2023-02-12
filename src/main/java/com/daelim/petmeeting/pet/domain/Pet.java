package com.daelim.petmeeting.pet.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Builder
@Table(name = "tbl_pet")
public class Pet {

    @Id
    private Long pid;
}
