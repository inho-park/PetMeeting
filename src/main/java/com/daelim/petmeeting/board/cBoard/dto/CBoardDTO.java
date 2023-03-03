package com.daelim.petmeeting.board.cBoard.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 화면에 보여줄 데이터를 전달할 DTO
public class CBoardDTO {

    private Long cbid;

    private String title;

    private String category;

    private String content;

    private String userId; // 작성자의 Id

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private int replyCount; //해당 게시글의 댓글 수


}
