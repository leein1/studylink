package org.leeinwon.studylink.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.leeinwon.studylink.dto.NoteDTO;
import org.leeinwon.studylink.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public void list(Model model) {

        log.info("컨트롤러 list 요청");
    }

    @GetMapping("/register")
    public void registerGET(){

        log.info("컨트롤러 registerGET 호출");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid NoteDTO noteDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("컨트롤러 registerPOST 호출");

        if(bindingResult.hasErrors()){
            log.info("bindingResult 에러");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/note/register";
        }

        log.info(noteDTO);

        noteService.register(noteDTO);

        return "redirect:/note/list";

    }
}
