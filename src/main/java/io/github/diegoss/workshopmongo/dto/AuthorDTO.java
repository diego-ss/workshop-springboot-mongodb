package io.github.diegoss.workshopmongo.dto;

import io.github.diegoss.workshopmongo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
