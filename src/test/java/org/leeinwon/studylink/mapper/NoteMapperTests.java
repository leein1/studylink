package org.leeinwon.studylink.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.leeinwon.studylink.domain.NoteVO;
import org.leeinwon.studylink.dto.NoteDTO;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

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
    public void testUpdate(){
//        NoteVO noteVO = noteMapper.selectOne(2l);
//
//        noteVO.builder()
//                .title("업데이트 테스트")
//                .content("업데이트 테스트")
//                .build();
//
//        log.info(noteVO);
//        noteMapper.update(noteVO);
//        잘못된 코드

        NoteVO noteVO = noteMapper.selectOne(2l);
        log.info(noteVO);

        NoteDTO noteDTO = modelMapper.map(noteVO, NoteDTO.class);
        noteDTO.setTitle("업데이트 테스트");
        noteDTO.setContent("업데이트 테스트");
        log.info(noteDTO);

        noteMapper.update(modelMapper.map(noteDTO, NoteVO.class));

    }

    @Test
    public void testDelete(){

        noteMapper.delete(11l);
        testSelectAll();
    }
}
