package shubhadhang.todolistapp.domain.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode


public class UserDtoView {
    private String email;
    private Set<RoleDtoView> roles;
}
