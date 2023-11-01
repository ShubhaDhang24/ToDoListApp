package shubhadhang.todolistapp.service;

import org.springframework.stereotype.Service;
import shubhadhang.todolistapp.domain.dto.RoleDtoForm;
import shubhadhang.todolistapp.domain.dto.RoleDtoView;
import shubhadhang.todolistapp.domain.dto.UserDtoForm;
import shubhadhang.todolistapp.domain.dto.UserDtoView;
import shubhadhang.todolistapp.domain.entity.Role;
import shubhadhang.todolistapp.domain.entity.User;
import shubhadhang.todolistapp.exception.DataDuplicateException;
import shubhadhang.todolistapp.exception.DataNotFoundException;
import shubhadhang.todolistapp.repository.RoleRepository;
import shubhadhang.todolistapp.repository.UserRepository;
import shubhadhang.todolistapp.util.CustomPasswordEncoder;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CustomPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, CustomPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDtoView register(UserDtoForm userDTOForm) {
        // Check params
        if (userDTOForm == null) throw new IllegalArgumentException("user form is null.");
        // Check if email exist
        boolean isExistEmail = userRepository.existsByEmail(userDTOForm.getEmail());
        if (isExistEmail) throw new DataDuplicateException("Email is already exist.");

        // Retrieve and validate roles
        Set<Role> roleList = userDTOForm.getRoles()
                .stream()
                .map(
                        roleDTOForm -> roleRepository.findById(roleDTOForm.getId())
                                .orElseThrow(() -> new DataNotFoundException("Role is not valid.")))
                .collect(Collectors.toSet());

        // Convert dto to entity
        User user = new User(userDTOForm.getEmail(), passwordEncoder.encode(userDTOForm.getPassword()));
        user.setRoles(roleList);

        // Create a new User entity
        User savedUser = userRepository.save(user);

        // Convert saved user to dto with converting roles
    /*UserDTOView dtoView = new UserDTOView();
    dtoView.setEmail(savedUser.getEmail());

    Set<RoleDTOView> roleDTOViewList = new HashSet<>();
    for (Role role: user.getRoles()){
      RoleDTOView roleDtoView = new RoleDTOView();
      roleDtoView.setId(role.getId());
      roleDtoView.setName(role.getName());
      roleDTOViewList.add(roleDtoView);
    }
    dtoView.setRoles(roleDTOViewList);*/

        Set<RoleDtoView> roleDTOViews = savedUser.getRoles()
                .stream()
                .map(
                        role -> RoleDtoView.builder()
                                .id(role.getId())
                                .name(role.getName())
                                .build())
                .collect(Collectors.toSet());

        //& return the result
        return UserDtoView.builder()
                .email(savedUser.getEmail())
                .roles(roleDTOViews)
                .build();
    }

    @Override
    public UserDtoView getByEmail(String email) {
        User user = userRepository.findById(email).orElseThrow(() -> new DataNotFoundException("Email does not exist."));

        Set<RoleDtoView> roleDTOViews = user.getRoles()
                .stream()
                .map(
                        role -> RoleDtoView.builder()
                                .id(role.getId())
                                .name(role.getName())
                                .build())
                .collect(Collectors.toSet());

        return UserDtoView.builder()
                .email(user.getEmail())
                .roles(roleDTOViews)
                .build();
    }

    @Override
    public void disableByEmail(String email) {
        isEmailTaken(email);
        userRepository.updateExpiredByEmail(email, true);
    }



    @Override
    public void enableByEmail(String email) {
        isEmailTaken(email);
        userRepository.updateExpiredByEmail(email, false);

    }
    private void isEmailTaken(String email){
        if (!userRepository.existsByEmail(email))
            throw new DataNotFoundException("Email does not exist.");
    }



}
