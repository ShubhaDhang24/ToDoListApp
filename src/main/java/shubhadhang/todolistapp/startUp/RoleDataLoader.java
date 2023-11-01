package shubhadhang.todolistapp.startUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shubhadhang.todolistapp.domain.entity.Role;
import shubhadhang.todolistapp.repository.RoleRepository;


@Component
public class RoleDataLoader implements CommandLineRunner {


    @Autowired
    private RoleRepository roleRepository;

    public RoleDataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // execute this logic...
        // How to call save method of RoleRepository Interface?
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("GUEST"));
        // add more roles as needed
    }


}