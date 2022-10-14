package amp;

import amp.model.ERole;
import amp.model.Role;
import amp.repository.RoleRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;

    public SetupDataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createRoles();
    }

    private void createRoles(){
        if(!roleRepository.existsByName(ERole.ROLE_USER)) {
            Role userRole = new Role(ERole.ROLE_USER);
            roleRepository.save(userRole);
        }
        if(!roleRepository.existsByName(ERole.ROLE_ADMIN)) {
            Role adminRole = new Role(ERole.ROLE_ADMIN);
            roleRepository.save(adminRole);
        }
        if(!roleRepository.existsByName(ERole.ROLE_MODERATOR)) {
            Role moderatorRole = new Role(ERole.ROLE_MODERATOR);
            roleRepository.save(moderatorRole);
        }
    }
}
