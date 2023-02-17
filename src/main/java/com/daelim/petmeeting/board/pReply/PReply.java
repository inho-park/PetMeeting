package com.daelim.petmeeting.board.pReply;

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
public class PReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prid;
}
