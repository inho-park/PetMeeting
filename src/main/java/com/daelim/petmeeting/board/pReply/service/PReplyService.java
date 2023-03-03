package com.daelim.petmeeting.board.pReply.service;

import com.daelim.petmeeting.board.pBoard.domain.PBoard;
import com.daelim.petmeeting.board.pReply.domain.PReply;
import com.daelim.petmeeting.board.pReply.domain.PReplyRepository;
import com.daelim.petmeeting.board.pReply.dto.ReplyDTO;
import com.daelim.petmeeting.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PReplyService {

    private final PReplyRepository replyRepository;

    public Long register(ReplyDTO replyDTO) {
        PReply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
        return reply.getPrid();
    }

    public List<ReplyDTO> getList(Long bno) {
        List<PReply> result
                = replyRepository.getPRepliesByPBoardOOrderByPrid(
                        PBoard.builder().pbid(bno).build());

        return result.stream().map(pReply -> entityToDTO(pReply)).collect(Collectors.toList());
    }

    public void modify(ReplyDTO replyDTO) {
        PReply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
    }

    public void remove(Long rno) {
        replyRepository.deleteById(rno);
    }


    // ReplyDTO를 Reply객체로 변환 : Board객체의 처리가 수반
    public PReply dtoToEntity(ReplyDTO replyDTO) {
        PBoard board = PBoard.builder().pbid(replyDTO.getBno()).build();
        User user = User.builder().userId(replyDTO.getReplyer()).build();

        PReply reply = PReply.builder()
                .prid(replyDTO.getRno())
                .content(replyDTO.getText())
                .user(user)
                .pBoard(board)
                .build();
        return reply;
    }

    public ReplyDTO entityToDTO(PReply reply) {
        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getPrid())
                .replyer(reply.getUser().getUserId())
                .text(reply.getContent())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();

        return replyDTO;
    }
}
