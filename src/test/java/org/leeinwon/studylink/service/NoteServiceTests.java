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
                .title("서비스 테스트6 깃 커밋 후 테스트")
                .content("서비스 테스트")
                .build();

        noteService.register(noteDTO);
    }

    @Test
    public void testGetList(){

        noteService.getList().forEach(dto -> log.info(dto));
    }

    @Test
    public void testGetOne(){

        log.info(noteService.getOne(1l));
    }

    @Test
    public void testRemove(){

        noteService.remove(10l);
    }
}
