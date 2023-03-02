package com.daelim.petmeeting.board.pBoard.controller;

import com.daelim.petmeeting.pet.domain.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pb")
public class PboardController {

    @Autowired
    private PetRepository petRepository;

//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody CreateRequestDTO dto) {
//        try {
//
//            return ResponseEntity<?>
//        }catch(Exception e) {
//
//        }
//    }

    @GetMapping
    public ResponseEntity<?> retrieve( ) {


        return null;
    }

}
