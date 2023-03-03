package com.daelim.petmeeting.repository;


import com.daelim.petmeeting.board.cBoard.cContoller.repository.CBoardRepository;
import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import com.daelim.petmeeting.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

// 모든 테스트 이상 무
@SpringBootTest
public class CBoardRepositoryTests {

    @Autowired
    private CBoardRepository cboardRepository;

    @Test
    public void insertBoard() {

        IntStream.rangeClosed(1,1).forEach(i -> {

            User user = User.builder().userId("와꾸의 난 " + i).build();

            CBoard cboard = CBoard.builder()
                    .title("Title..."+i)
                    .content("Content...." + i)
                    .cCategory("자랑")
                    .user(user)
                    .build();

            cboardRepository.save(cboard);

        });
    }


    @Transactional
    @Test
    public void testRead1() {

        Optional<CBoard> result = cboardRepository.findById(100L); //데이터베이스에 존재하는 번호

        CBoard board = result.get();

        System.out.println(board);
        System.out.println(board.getUser());

    }

    @Test
    public void testReadWithWriter() {

        Object result = cboardRepository.getBoardWithWriter(100L);

        Object[] arr = (Object[])result;

        System.out.println("-------------------------------");
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void testGetBoardWithReply() {

        List<Object[]> result = cboardRepository.getBoardWithReply(100L);

        for (Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }


    @Test
    public void testWithReplyCount(){

        Pageable pageable = PageRequest.of(0,10, Sort.by("cbid").descending());

        Page<Object[]> result = cboardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {

            Object[] arr = (Object[])row;

            System.out.println(Arrays.toString(arr));
        });
    }

    @Test
    public void testRead3() {

        Object result = cboardRepository.getCBoardByCbid(100L);

        Object[] arr = (Object[])result;

        System.out.println(Arrays.toString(arr));
    }

//    @Test
//    public void testSearch1() {
//
//        cboardRepository.search1();
//
//    }

//    @Test
//    public void testSearchPage() {
//
//        Pageable pageable =
//                PageRequest.of(0,10,
//                        Sort.by("bno").descending()
//                                .and(Sort.by("title").ascending()));
//
//        Page<Object[]> result = cboardRepository.searchPage("t", "1", pageable);
//
//    }

//    @Test
//    public void testSearch(){
//
//        PageRequestDTO pageRequestDTO = new PageRequestDTO();
//        pageRequestDTO.setPage(1);
//        pageRequestDTO.setSize(10);
//        pageRequestDTO.setType("twc");
//        pageRequestDTO.setKeyword("3");
//
//        Pageable pageable = pageRequestDTO.getPageable(Sort.by("bno").descending());
//
//        Page<Object[]> result = boardRepository.searchList( pageRequestDTO );
//
//        System.out.println(result);
//
//        result.get().forEach(row -> {
//
//            Object[] arr = (Object[])row;
//
//            System.out.println(Arrays.toString(arr));
//        });
//
//    }


}
