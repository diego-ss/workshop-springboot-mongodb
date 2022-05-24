package io.github.diegoss.workshopmongo.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@EqualsAndHashCode
@Builder
public class CommentDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO authorDTO;
}
