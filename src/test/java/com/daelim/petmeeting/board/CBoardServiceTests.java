package com.daelim.petmeeting.board;

import com.daelim.petmeeting.board.cBoard.Service.CBoardService;
import com.daelim.petmeeting.board.cBoard.dto.CBoardDTO;
import com.daelim.petmeeting.board.dto.PageRequestDTO;
import com.daelim.petmeeting.board.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


// 모든 테스트 이상 무
@SpringBootTest
public class CBoardServiceTests {

    @Autowired
    private CBoardService cboardService;

    @Test
    public void testRegister() {

        CBoardDTO dto = CBoardDTO.builder()
                .title("Test.")
                .content("Test...")
                .userId("와꾸의 난 20")  //현재 데이터베이스에 존재하는 회원 id
                .build();

        Long cbid = cboardService.register(dto);

    }

    @Test
    public void testList() {

        //1페이지 10개
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<CBoardDTO, Object[]> result = cboardService.getList(pageRequestDTO);

        for (CBoardDTO boardDTO : result.getDtoList()) {
            System.out.println(boardDTO);
        }

    }

    @Test
    public void testGet() {

        Long cbid = 100L;

        CBoardDTO boardDTO = cboardService.get(cbid);

        System.out.println(boardDTO);
    }

    @Test
    public void testRemove() {

        Long cbid = 102L;

       cboardService.removeWithReplies(cbid);

    }

    @Test
    public void testModify() {

        CBoardDTO boardDTO = CBoardDTO.builder()
                .cbid(2L)
                .title("제목 변경합니다.2")
                .content("내용 변경합니다.2")
                .build();

        cboardService.modify(boardDTO);

    }


//    @Test
//    public void testSearch(){
//
//        PageRequestDTO pageRequestDTO = new PageRequestDTO();
//        pageRequestDTO.setPage(1);
//        pageRequestDTO.setSize(10);
//        pageRequestDTO.setType("t");
//        pageRequestDTO.setKeyword("11");
//
//        Pageable pageable = pageRequestDTO.getPageable(Sort.by("bno").descending());
//
//        PageResultDTO<CBoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
//
//        for (BoardDTO boardDTO : result.getDtoList()) {
//            System.out.println(boardDTO);
//        }
}

