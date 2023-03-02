package com.daelim.petmeeting.board.pBoard.controller;
import com.daelim.petmeeting.board.dto.PageRequestDTO;
import com.daelim.petmeeting.board.pBoard.service.PboardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/pb/")
public class PboardController {
    private PboardService pboardService;

//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody CreateRequestDTO dto) {
//        try {
//
//            return ResponseEntity<?>
//        }catch(Exception e) {
//
//        }
//    }

    @GetMapping({"/list","/"})
    public void list(PageRequestDTO pageRequestDTO,
                     Model model,
                     boolean pcategory) {
        log.info("list.............................." + pageRequestDTO);
        model.addAttribute("response", pboardService.getList(pageRequestDTO, pcategory));
    }

    @GetMapping
    public ResponseEntity<?> retrieve(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
                                      boolean category,
                                      Model model) {
        return null;
    }

}
