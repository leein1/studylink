package org.leeinwon.studylink.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.leeinwon.studylink.dto.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class NoteServiceTests {

    @Autowired
    private NoteService noteService;

    @Test
    public void testResgister(){

        NoteDTO noteDTO = NoteDTO.builder()
                .title("서비스 테스트5 작성일 컬럼 데이터 타입 datetime 변경")
                .content("서비스 테스트")
                .build();

        noteService.register(noteDTO);
    }
}
