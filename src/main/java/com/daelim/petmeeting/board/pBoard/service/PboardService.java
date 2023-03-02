package com.daelim.petmeeting.board.pBoard.service;

import com.daelim.petmeeting.board.dto.PageRequestDTO;
import com.daelim.petmeeting.board.dto.PageResultDTO;
import com.daelim.petmeeting.board.pBoard.domain.PBoard;
import com.daelim.petmeeting.board.pBoard.domain.PBoardRepository;
import com.daelim.petmeeting.board.pBoard.dto.PBoardDTO;
import com.daelim.petmeeting.pet.domain.PetRepository;
import com.daelim.petmeeting.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Log4j2
@Service
@RequiredArgsConstructor
public class PboardService {
    @Autowired
    private PBoardRepository pBoardRepository;

    public PageResultDTO<PBoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO, boolean category) {
        log.info(pageRequestDTO);
        Function<Object[], PBoardDTO> fn = (
                entity -> entityToDTO((PBoard)entity[0],
                        (User)entity[1],
                        (Long)entity[2])
        );
        Page<Object[]> result = pBoardRepository.findByPCategory(category,
                pageRequestDTO.getPageable(Sort.by("regdate").descending()));

//        Page<Object[]> result = repository.searchPage(
//                pageRequestDTO.getType(),
//                pageRequestDTO.getKeyword(),
//                pageRequestDTO.getPageable(Sort.by("bno").descending()
//                )
//        );

        return new PageResultDTO<>(result, fn);
    }



    PBoard dtoToEntity(PBoardDTO dto) {
        User user = User.builder().email(dto.getWriterId()).build();
        PBoard board = PBoard.builder()
                .pbid(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .build();
        return board;
    }

    PBoardDTO entityToDTO(PBoard board, User user, Long replyCount) {
        PBoardDTO boardDTO = PBoardDTO.builder()
                .bno(board.getPbid())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerId(user.getUserId())
                .build();

        return boardDTO;
    }
}
