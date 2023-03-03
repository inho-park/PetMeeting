package com.daelim.petmeeting.board.cReply.controller;

import com.daelim.petmeeting.board.cReply.dto.CReplyDTO;
import com.daelim.petmeeting.board.cReply.service.CReplyService;

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
@RequestMapping("/cr/")
public class CReplyController {
    private final CReplyService cReplyService;

    @GetMapping(value = "/cboard/{cbid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CReplyDTO>> getListByBoard(@PathVariable("cbid") Long cbid){
        log.info("cbid : " + cbid);
        return new ResponseEntity<>(cReplyService.getList(cbid), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody CReplyDTO creplyDTO) {
        log.info(creplyDTO);
        Long cbid = cReplyService.register(creplyDTO);
        return new ResponseEntity<>(cbid, HttpStatus.OK);
    }

    @DeleteMapping("/{crno}")
    public ResponseEntity<String> remove(@PathVariable("crno") Long crno) {
        log.info("REMOVE RNO : " + crno);
        cReplyService.remove(crno);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/{crno}")
    public ResponseEntity<String> modify(@RequestBody CReplyDTO dto) {
        log.info("MODIFY CReplyDTO : " + dto);
        cReplyService.modify(dto);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
