package org.leeinwon.studylink.mapper;

import org.leeinwon.studylink.domain.NoteVO;

import java.util.List;

public interface TestMapper {

    String getNow();

    List<NoteVO> selectList();

}
