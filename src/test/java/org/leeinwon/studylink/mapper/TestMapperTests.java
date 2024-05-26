package org.leeinwon.studylink.mapper;

import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
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
public class TestMapperTests {

    @Autowired(required = false)
    private TestMapper mapper;

    @Test
    public void testGetNow(){
        log.info(mapper.getNow());
    }

    @Test
    public void testSelectList(){
        List<NoteVO> voList = mapper.selectList();

        voList.forEach(vo -> log.info(vo));
    }
}
