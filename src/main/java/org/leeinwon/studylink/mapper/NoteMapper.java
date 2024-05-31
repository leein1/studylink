package org.leeinwon.studylink.mapper;

import org.leeinwon.studylink.domain.NoteVO;
import org.leeinwon.studylink.dto.SearchDTO;

import java.util.List;

public interface NoteMapper {

    void insert(NoteVO noteVO);

    List<NoteVO> selectAll();

    List<NoteVO> selectSearchList(SearchDTO searchDTO);

    NoteVO selectOne(long id);

    void update(NoteVO noteVO);

    void delete(long id);
}
