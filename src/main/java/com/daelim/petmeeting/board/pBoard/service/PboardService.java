package com.daelim.petmeeting.board.pBoard.service;

import com.daelim.petmeeting.board.dto.PageRequestDTO;
import com.daelim.petmeeting.board.dto.PageResultDTO;
import com.daelim.petmeeting.board.pBoard.domain.PBoard;
import com.daelim.petmeeting.board.pBoard.domain.PBoardRepository;
import com.daelim.petmeeting.board.pBoard.dto.PBoardDTO;
import com.daelim.petmeeting.board.pReply.domain.PReplyRepository;
import com.daelim.petmeeting.pet.domain.Pet;
import com.daelim.petmeeting.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Log4j2
@Service
@RequiredArgsConstructor
public class PboardService {
    @Autowired
    private PBoardRepository pBoardRepository;

    @Autowired
    private PReplyRepository pReplyRepository;

    public PageResultDTO<PBoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO, boolean category) {
        log.info(pageRequestDTO);
        Function<Object[], PBoardDTO> fn = (
                entity -> entityToDTO((PBoard)entity[0],
                        (User)entity[1],
                        (Pet)entity[2])
        );
        Page<Object[]> result = pBoardRepository.findByPCategory(category,
                pageRequestDTO.getPageable(Sort.by("regdate").descending()));

//        Page<Object[]> result = repository.searchPage(
//                pageRequestDTO.getType(),
//                pageRequestDTO.getKeyword(),
//                pageRequestDTO.getPageable(Sort.by("pbid").descending()
//                )
//        );

        return new PageResultDTO<>(result, fn);
    }

    @Transactional
    public Long retrieve(PBoardDTO dto) {
        log.info("retrieve DTO : " + dto);
        return pBoardRepository.save(dtoToEntity(dto)).getPbid();
    }

    @Transactional
    public PBoardDTO get(Long bno) {
        Object[] result = (Object[]) pBoardRepository.getPBoardByBno(bno);
        return entityToDTO((PBoard) result[0], (User) result[1], (Pet) result[2]);
    }

    @Transactional
    public void removeWithReplies(Long bno) {
        pReplyRepository.deleteById(bno);
        pBoardRepository.deleteById(bno);
    }

    @javax.transaction.Transactional
    public void modify(PBoardDTO boardDTO) {
        // getOne -> 필요한 순간까지 로딩을 지연하는 방식
        // 현재는 deprecated 되어 getReferenceById() 를 사용
        PBoard board = pBoardRepository.getReferenceById(boardDTO.getBno());

        board.changeTitle(boardDTO.getTitle());
        board.changeContent(boardDTO.getContent());
        pBoardRepository.save(board);
    }

    PBoard dtoToEntity(PBoardDTO dto) {
        User user = User.builder().email(dto.getWriterId()).build();
        Pet pet = Pet.builder().pid(dto.getPid()).build();
        PBoard board = PBoard.builder()
                .pbid(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .pet(pet)
                .build();
        return board;
    }

    PBoardDTO entityToDTO(PBoard board, User user, Pet pet) {

        PBoardDTO boardDTO = PBoardDTO.builder()
                .bno(board.getPbid())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerId(user.getUserId())
                .pid(pet.getPid())
                .build();

        return boardDTO;
    }
}
