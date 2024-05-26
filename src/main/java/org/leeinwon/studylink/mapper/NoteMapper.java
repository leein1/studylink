package org.leeinwon.studylink.mapper;

import org.leeinwon.studylink.domain.NoteVO;

import java.util.List;

public interface NoteMapper {

    void insert(NoteVO noteVO);

    List<NoteVO> selectAll();
}
