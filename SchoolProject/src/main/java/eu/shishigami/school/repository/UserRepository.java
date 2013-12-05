package eu.shishigami.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.shishigami.school.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public UserEntity findByUsername(String username);

}
