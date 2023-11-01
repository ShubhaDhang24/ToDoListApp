package shubhadhang.todolistapp.service;

import shubhadhang.todolistapp.domain.dto.UserDtoForm;
import shubhadhang.todolistapp.domain.dto.UserDtoView;

public interface UserService {
    UserDtoView register(UserDtoForm userDTOForm);

    UserDtoView getByEmail(String email);

    void disableByEmail(String email);

    void enableByEmail(String email);
}
