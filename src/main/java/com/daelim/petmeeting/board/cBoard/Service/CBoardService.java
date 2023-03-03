package com.daelim.petmeeting.board.cBoard.Service;


import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import com.daelim.petmeeting.board.cBoard.dto.CBoardDTO;
import com.daelim.petmeeting.board.dto.PageRequestDTO;
import com.daelim.petmeeting.board.dto.PageResultDTO;
import com.daelim.petmeeting.user.domain.User;
import org.springframework.transaction.annotation.Transactional;

public interface CBoardService {


    Long register(CBoardDTO dto);

    PageResultDTO<CBoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    CBoardDTO get(Long cbid);

    void removeWithReplies(Long cbid);

    default CBoard dtoToEntity(CBoardDTO dto) {

        User user = User.builder().userId(dto.getUserId()).build();


        CBoard cboard = CBoard.builder()
                .cbid(dto.getCbid())
                .cCategory(dto.getTitle())
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .build();
        return cboard;
    }

    default CBoardDTO entityToDTO(CBoard cboard, User user, Long replyCount) {

        CBoardDTO cboardDTO = CBoardDTO.builder()
                .cbid(cboard.getCbid())
                .category(cboard.getCCategory())
                .title(cboard.getTitle())
                .content(cboard.getContent())
                .regDate(cboard.getRegDate())
                .modDate(cboard.getModDate())
                .userId(user.getUserId())
                .replyCount(replyCount.intValue()) //int로 처리하도록
                .build();

        return cboardDTO;

    }

    @Transactional
    void modify(CBoardDTO boardDTO);
}
