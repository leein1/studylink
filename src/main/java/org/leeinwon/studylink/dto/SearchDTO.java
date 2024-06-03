package org.leeinwon.studylink.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDTO {

//    제목 검색을 위한 변수
//    private String title;

//    내용 검색을 위한 변수
//    private String content;

//    검색조건 저장할 Collection
    private List<String> types;

//    검색어 저장할 Sring
    private String keyword;

}
