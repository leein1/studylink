package org.leeinwon.studylink.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDTO {

//    제목 검색을 위한 변수
    private String title;

//    내용 검색을 위한 변수
    private String content;

}
