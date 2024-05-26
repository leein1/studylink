package org.leeinwon.studylink.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NoteVO {

    private long id;

    private String title;

    private String content;

    private LocalDateTime createdate;
}
