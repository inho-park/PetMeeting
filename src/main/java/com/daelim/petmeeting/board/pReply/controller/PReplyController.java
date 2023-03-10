package com.daelim.petmeeting.board.pReply.controller;

import com.daelim.petmeeting.board.pReply.dto.ReplyDTO;
import com.daelim.petmeeting.board.pReply.service.PReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/pr/")
public class PReplyController {
    private final PReplyService pReplyService;

    @GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno){
        log.info("bno : " + bno);
        return new ResponseEntity<>(pReplyService.getList(bno), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO) {
        log.info(replyDTO);
        Long rno = pReplyService.register(replyDTO);
        return new ResponseEntity<>(rno, HttpStatus.OK);
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
        log.info("REMOVE RNO : " + rno);
        pReplyService.remove(rno);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ReplyDTO dto) {
        log.info("MODIFY ReplyDTO : " + dto);
        pReplyService.modify(dto);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
