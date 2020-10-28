package app.service;

import app.model.Role;
import app.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vasil
 */
@Service
@Slf4j
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }
}
