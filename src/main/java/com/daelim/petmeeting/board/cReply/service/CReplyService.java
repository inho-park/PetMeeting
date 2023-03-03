package com.daelim.petmeeting.board.cReply.service;

import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import com.daelim.petmeeting.board.cReply.domain.CReply;

import com.daelim.petmeeting.board.cReply.domain.CReplyRepository;
import com.daelim.petmeeting.board.cReply.dto.CReplyDTO;
import com.daelim.petmeeting.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CReplyService {

    private final CReplyRepository creplyRepository;

    public Long register(CReplyDTO creplyDTO) {
        CReply creply = dtoToEntity(creplyDTO);
        creplyRepository.save(creply);
        return creply.getCrid();
    }

    public List<CReplyDTO> getList(Long cbid) {
        List<CReply> result
                = creplyRepository.getCRepliesByCBoardOOrderByCrid(
                        CBoard.builder().cbid(cbid).build());

        return result.stream().map(cReply -> entityToDTO(cReply)).collect(Collectors.toList());
    }

    public void modify(CReplyDTO creplyDTO) {
        CReply creply = dtoToEntity(creplyDTO);
        creplyRepository.save(creply);
    }

    public void remove(Long crno) {
        creplyRepository.deleteById(crno);
    }


    // ReplyDTO를 Reply객체로 변환 : Board객체의 처리가 수반
    public CReply dtoToEntity(CReplyDTO replyDTO) {
        CBoard cboard = CBoard.builder().cbid(replyDTO.getBno()).build();

        User user = User.builder().userId(replyDTO.getReplyer()).build();

        CReply creply = CReply.builder()
                .crid(replyDTO.getCrno())
                .content(replyDTO.getText())
                .user(user)
                .cBoard(cboard)
                .build();
        return creply;
    }

    public CReplyDTO entityToDTO(CReply creply) {
        CReplyDTO creplyDTO = CReplyDTO.builder()
                .crno(creply.getCrid())
                .replyer(creply.getUser().getUserId())
                .text(creply.getContent())
                .regDate(creply.getRegDate())
                .modDate(creply.getModDate())
                .build();

        return creplyDTO;
    }
}
