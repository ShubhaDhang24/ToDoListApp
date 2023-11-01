package shubhadhang.todolistapp.service;

import shubhadhang.todolistapp.domain.dto.RoleDtoView;
import shubhadhang.todolistapp.domain.entity.Role;

import java.util.List;

public interface RoleService {
    List<RoleDtoView> getAll();
}
