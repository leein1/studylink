package org.leeinwon.studylink.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.leeinwon.studylink.domain.NoteVO;
import org.leeinwon.studylink.dto.NoteDTO;
import org.leeinwon.studylink.mapper.NoteMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{

    private final NoteMapper noteMapper;

    private final ModelMapper modelMapper;

    @Override
    public void register(NoteDTO noteDTO) {

        log.info("노트 서비스 register 호출");

        NoteVO noteVO = modelMapper.map(noteDTO, NoteVO.class);

        log.info(noteDTO);

        noteMapper.insert(noteVO);
    }

    @Override
    public List<NoteDTO> getList() {

        log.info("노트 서비스 getAllNotes 호출");

        List<NoteDTO> noteDTOList = noteMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, NoteDTO.class))
                .collect(Collectors.toList());

        return noteDTOList;
    }

    @Override
    public NoteDTO getOne(long id) {

        log.info("노트 서비스 getOne 호출");

        NoteVO noteVO = noteMapper.selectOne(id);
        NoteDTO noteDTO = modelMapper.map(noteVO, NoteDTO.class);

        return noteDTO;
    }

    @Override
    public void modify(NoteDTO noteDTO) {

        log.info("노트 서비스 modify 호출");

        NoteVO noteVO = modelMapper.map(noteDTO, NoteVO.class);
        noteMapper.update(noteVO);
    }

    @Override
    public void remove(long id) {

        log.info("노트 서비스 remove 호출");
        noteMapper.delete(id);
    }
}
