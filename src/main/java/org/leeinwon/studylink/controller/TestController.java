package org.leeinwon.studylink.controller;

import lombok.Getter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class TestController {

    @GetMapping("/test")
    public void test(){
        log.info("/test 경로 get 요청 받음");
    }

    @GetMapping("/conversion")
    public void localDateTest(LocalDate localDate){
        log.info("날짜 컨버전 테스트");
        log.info(localDate);
    }
}
