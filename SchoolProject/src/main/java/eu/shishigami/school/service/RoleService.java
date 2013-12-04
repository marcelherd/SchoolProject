package eu.shishigami.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.shishigami.school.domain.RoleEntity;
import eu.shishigami.school.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Transactional(readOnly = false)
	public void delete(final RoleEntity roleEntity) {
		roleRepository.delete(roleEntity);
	}

	@Transactional(readOnly = false)
	public RoleEntity save(final RoleEntity roleEntity) {
		return roleRepository.save(roleEntity);
	}
	
	public RoleEntity findByRoleName(final String roleName) {
		return roleRepository.findByRoleName(roleName);
	}
	
	public RoleEntity findOne(final Long id) {
		return roleRepository.findOne(id);
	}
	
	public List<RoleEntity> findAll() {
		return roleRepository.findAll();
	}

}
