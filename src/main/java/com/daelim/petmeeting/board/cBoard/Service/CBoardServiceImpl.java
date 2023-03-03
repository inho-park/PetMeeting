package com.daelim.petmeeting.board.cBoard.Service;


import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import com.daelim.petmeeting.board.cBoard.cContoller.repository.CBoardRepository;
import com.daelim.petmeeting.board.cBoard.dto.CBoardDTO;
import com.daelim.petmeeting.board.cReply.domain.CReplyRepository;
import com.daelim.petmeeting.board.dto.PageRequestDTO;
import com.daelim.petmeeting.board.dto.PageResultDTO;
import com.daelim.petmeeting.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class CBoardServiceImpl implements CBoardService{

    private final CBoardRepository cBoardRepository;

    private final CReplyRepository creplyRepository;



    @Override
    public Long register(CBoardDTO dto) {

        log.info(dto);

        CBoard cboard  = dtoToEntity(dto);

        cBoardRepository.save(cboard);

        return cboard.getCbid();
    }

    @Override
    public PageResultDTO<CBoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

        log.info(pageRequestDTO);

        Function<Object[], CBoardDTO> fn = (en -> entityToDTO((CBoard)en[0],(User)en[1],(Long)en[2]));

        Page<Object[]> result = cBoardRepository.getBoardWithReplyCount(
                pageRequestDTO.getPageable(Sort.by("cbid").descending())  );


        return new PageResultDTO<>(result, fn);
    }

    @Override
    public CBoardDTO get(Long cbid) {

        Object result = cBoardRepository.getCBoardByCbid(cbid);

        Object[] arr = (Object[])result;

        return entityToDTO((CBoard)arr[0], (User) arr[1], (Long)arr[2]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long cbid) {

        //댓글 부터 삭제
        creplyRepository.deleteBycbid(cbid);

        cBoardRepository.deleteById(cbid);

    }
    @Transactional
    @Override
    public void modify(CBoardDTO boardDTO) {

        CBoard cboard = cBoardRepository.getOne(boardDTO.getCbid());

        if(cboard != null) {

            cboard.changeTitle(boardDTO.getTitle());
            cboard.changeContent(boardDTO.getContent());

            cBoardRepository.save(cboard);
        }
    }
}
