package com.daelim.petmeeting.board.pBoard.controller;
import com.daelim.petmeeting.board.cReply.dto.PageRequestDTO;
import com.daelim.petmeeting.board.pBoard.dto.PBoardDTO;
import com.daelim.petmeeting.board.pBoard.service.PboardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/register")
    public void register() { log.info("register get.........................");};
    @GetMapping("/register")
    public String register(PBoardDTO dto, RedirectAttributes redirectAttributes ) {
        redirectAttributes.addFlashAttribute("response",pboardService.retrieve(dto));
        log.info("dto : " + dto);
        return "redirect:/pb/list";
    }

    @GetMapping({"/read","/modify"})
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
                     Model model,
                     Long bno
    ){
        log.info("read get.........................bno : " + bno);
        PBoardDTO boardDTO = pboardService.get(bno);
        model.addAttribute("dto",boardDTO);
    }

    @PostMapping("/remove")
    public String remove(long bno,
                         RedirectAttributes redirectAttributes
    ) {
        log.info("remove post.........................bno : " + bno);
        pboardService.removeWithReplies(bno);
        redirectAttributes.addFlashAttribute("msg", bno);
        return "redirect:/pb/list";
    }

    @PostMapping("/modify")
    public String registerPost(PBoardDTO dto,
                               RedirectAttributes redirectAttributes,
                               @ModelAttribute("requestDTO") PageRequestDTO requestDTO
    ) {
        log.info("modify post..........................dto : " + dto);
        pboardService.modify(dto);
        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());

        return "redirect:/pb/read";
    }
}
