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

        log.info("노트 컨트롤러 list 요청");
        model.addAttribute("dtoList",noteService.getList());
    }

    @GetMapping({"/read", "/modify"})
    public void read(long id, Model model) {

        log.info("노트 컨트롤러 read /modify 요청");
        log.info(id);

        NoteDTO noteDTO = noteService.getOne(id);
        model.addAttribute("dto",noteDTO);

    }

    @PostMapping("/modify")
    public String modifyPOST(@Valid NoteDTO noteDTO, BindingResult bindingResult,RedirectAttributes redirectAttributes){

        log.info("노트 컨트롤러 modifyPOST 호출");

        if (bindingResult.hasErrors()) {
            log.info("bindingResult 에러");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/note/modify?id=" + noteDTO.getId();
        }

        noteService.modify(noteDTO);

        return "redirect:/note/list";
    }

    @GetMapping("/register")
    public void registerGET(){

        log.info("노트 컨트롤러 registerGET 호출");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid NoteDTO noteDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("노트 컨트롤러 registerPOST 호출");

        if(bindingResult.hasErrors()){
            log.info("bindingResult 에러");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/note/register";
        }

        log.info(noteDTO);

        noteService.register(noteDTO);

        return "redirect:/note/list";

    }

    @PostMapping("/remove")
    public String removePOST(long id){

        log.info("노트 컨트롤러 removePOST 호출");

        noteService.remove(id);
        return "redirect:/note/list";
    }
}
