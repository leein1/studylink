package org.leeinwon.studylink.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.leeinwon.studylink.domain.NoteVO;
import org.leeinwon.studylink.dto.NoteDTO;
import org.leeinwon.studylink.dto.SearchDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {

    void register(NoteDTO noteDTO);

    List<NoteDTO> getList();

    List<NoteDTO> getSearchList(SearchDTO searchDTO);

    NoteDTO getOne(long id);

    void modify(NoteDTO noteDTO);

    void remove(long id);
}
