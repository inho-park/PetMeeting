package com.daelim.petmeeting.repository;
import com.daelim.petmeeting.board.cBoard.domain.CBoard;
import com.daelim.petmeeting.board.cReply.domain.CReply;
import com.daelim.petmeeting.board.cReply.domain.CReplyRepository;
import com.daelim.petmeeting.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class CReplyRepositoryTests {

    @Autowired
    private CReplyRepository cReplyRepository;

    @Test
    public void insertReply() {

        IntStream.rangeClosed(1, 300).forEach(i -> {
            //1부터 100까지의 임의의 번호
            long radom_num  = (long)(Math.random() * 100) + 1;

            // 1번 ~ 100번의 임의 유저가 댓글 작성
            User user = User.builder().userId("와꾸의 난 " + radom_num).build();

            CBoard cboard = CBoard.builder().cbid(radom_num).build();

            CReply creply = CReply.builder()
                    .content("Reply......." +i)
                    .cBoard(cboard)
                    .user(user)
                    .build();

            cReplyRepository.save(creply);

        });

    }

    @Test
    public void readReply1() {

        Optional<CReply> result = cReplyRepository.findById(1L);

        CReply creply = result.get();

        System.out.println(creply);
        System.out.println(creply.getCBoard());

    }
}
