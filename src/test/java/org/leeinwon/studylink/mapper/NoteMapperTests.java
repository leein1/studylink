package org.leeinwon.studylink.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.leeinwon.studylink.domain.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class NoteMapperTests {

    @Autowired(required = false)
    private NoteMapper noteMapper;

    @Test
    public void testInsert(){

        NoteVO noteVO = NoteVO.builder()
                .title("매퍼 테스트2")
                .content("내용 테스트2")
                .build();

        noteMapper.insert(noteVO);
    }

    @Test
    public void testSelectAll(){

        List<NoteVO> noteVoList = noteMapper.selectAll();

        noteVoList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne(){

        NoteVO noteVO = noteMapper.selectOne(1l);
        log.info(noteVO);
    }

    @Test
    public void testDelete(){

        noteMapper.delete(11l);
        testSelectAll();
    }
}
