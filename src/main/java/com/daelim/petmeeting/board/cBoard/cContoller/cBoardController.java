package com.daelim.petmeeting.board.cBoard.cContoller;

import com.daelim.petmeeting.board.cBoard.Service.CBoardService;
import com.daelim.petmeeting.board.cBoard.dto.CBoardDTO;
import com.daelim.petmeeting.board.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cboard/")
@Log4j2
public class cBoardController {

    @Autowired
    private CBoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        log.info("list............." + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));

    }

    @GetMapping("/register")
    public void register(){
        log.info("regiser get...");
    }

    @PostMapping("/register")
    public String registerPost(CBoardDTO cdto, RedirectAttributes redirectAttributes){

        log.info("cdto..." + cdto);
        //새로 추가된 엔티티의 번호
        Long cbid = boardService.register(cdto);

        log.info("cbid: " + cbid);

        redirectAttributes.addFlashAttribute("msg", cbid);

        return "redirect:/cboard/list";
    }

    @GetMapping({"/read", "/modify" })
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long cbid, Model model){

        log.info("cbid: " + cbid);

        CBoardDTO cboardDTO = boardService.get(cbid);

        log.info(cboardDTO);

        model.addAttribute("dto", cboardDTO);

    }


    @PostMapping("/remove")
    public String remove(long cbid, RedirectAttributes redirectAttributes){


        log.info("cbid: " + cbid);

        boardService.removeWithReplies(cbid);

        redirectAttributes.addFlashAttribute("msg", cbid);

        return "redirect:/cboard/list";

    }

    @PostMapping("/modify")
    public String modify(CBoardDTO cdto,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){


        log.info("post modify.........................................");
        log.info("cdto: " + cdto);

        boardService.modify(cdto);

        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());

        redirectAttributes.addAttribute("cbid",cdto.getCbid());

        return "redirect:/cboard/read";

    }


}
