package shubhadhang.todolistapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shubhadhang.todolistapp.converter.RoleConverter;
import shubhadhang.todolistapp.domain.dto.RoleDtoView;
import shubhadhang.todolistapp.domain.entity.Role;
import shubhadhang.todolistapp.repository.RoleRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleConverter roleConverter;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleConverter roleConverter) {
        this.roleRepository = roleRepository;
        this.roleConverter = roleConverter;
    }

    @Override
    public List<RoleDtoView> getAll() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDtoView> roleDTOList = new ArrayList<>();
        for (Role entity : roles) {
            roleDTOList.add(roleConverter.toRoleDtoView(entity));
        }
        return roleDTOList;
    }

}