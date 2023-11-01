package shubhadhang.todolistapp.domain.dto;

import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDtoForm {
    private String email;
    private String password;
    private Set<RoleDtoForm> roles;
}
