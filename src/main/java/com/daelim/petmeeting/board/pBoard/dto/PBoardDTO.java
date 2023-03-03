package com.daelim.petmeeting.board.pBoard.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PBoardDTO {
    private Long bno;
    private String title;
    private String content;
    private String writerId;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
