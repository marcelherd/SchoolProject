package eu.shishigami.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.shishigami.school.domain.UserEntity;
import eu.shishigami.school.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = false)
	public void delete(final UserEntity userEntity) {
		userRepository.delete(userEntity);
	}

	@Transactional(readOnly = false)
	public UserEntity save(final UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	
	public UserEntity findByUsername(final String username) {
		return userRepository.findByUsername(username);
	}
	
	public UserEntity findOne(final Long id) {
		return userRepository.findOne(id);
	}
	
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

}
