package com.daelim.petmeeting.repository;

import com.daelim.petmeeting.pet.domain.Pet;
import com.daelim.petmeeting.pet.domain.PetRepository;
import com.daelim.petmeeting.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class PetRepositoryTests {

    @Autowired
    private PetRepository repository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            User user = User.builder().uid((long)i).build();

            Pet pet = Pet.builder()
                    .petAge(i)
                    .petName("삐삐 " + i)
                    .petPhoto("image_uuid " + i)
                    .petWeight(i + 0.25f)
                    .petSpecies("시고르갱어르지 " + i)
                    .petnallity("순함 " + i)
                    .tbl_user(user)
                    .build();
            repository.save(pet);

        });
    }

}
