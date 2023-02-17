package com.daelim.petmeeting.board.cReply;

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
public class CReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crid;


}
