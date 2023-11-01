package shubhadhang.todolistapp.converter;

import org.springframework.stereotype.Component;
import shubhadhang.todolistapp.domain.dto.RoleDtoView;
import shubhadhang.todolistapp.domain.entity.Role;

@Component
public class RoleConverterImpl implements RoleConverter{

    @Override
    public RoleDtoView toRoleDtoView(Role entity) {
        return RoleDtoView.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
        //return new RoleDTOView(entity.getId(), entity.getName());
    }

    @Override
    public Role toRoleEntity(RoleDtoView dtoView) {
        return Role.builder().id(dtoView.getId()).name(dtoView.getName()).build();
        //return new Role(dtoView.getId(), dtoView.getName());
    }
}