package org.leeinwon.studylink.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NoteVO {

    private int id;

    private String title;

    private String content;
}
