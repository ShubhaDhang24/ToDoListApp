package shubhadhang.todolistapp.converter;

import shubhadhang.todolistapp.domain.dto.RoleDtoView;
import shubhadhang.todolistapp.domain.entity.Role;



    public interface RoleConverter {

        RoleDtoView toRoleDtoView(Role entity);

        Role toRoleEntity(RoleDtoView dtoView);
    }

