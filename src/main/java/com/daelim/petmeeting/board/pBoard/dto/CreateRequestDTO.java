package com.daelim.petmeeting.board.pBoard.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateRequestDTO {
    private String title;
    private boolean pcategory;
    private String content;

}
