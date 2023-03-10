package com.daelim.petmeeting.board.cReply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CReplyDTO {
    private Long crno;
    private String text;
    private String replyer;
    private Long bno;
    private LocalDateTime regDate, modDate;

}
