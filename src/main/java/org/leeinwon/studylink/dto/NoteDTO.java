package org.leeinwon.studylink.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDTO {

    private int id;

    @NotEmpty
    private String title;

    private String content;

}
