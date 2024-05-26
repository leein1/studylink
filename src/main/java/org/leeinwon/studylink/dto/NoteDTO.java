package org.leeinwon.studylink.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDTO {

    private long id;

    @NotEmpty
    private String title;

    private String content;

    private LocalDate date;

    private LocalDateTime createdate;

}
