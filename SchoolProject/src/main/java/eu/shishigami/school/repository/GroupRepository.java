package eu.shishigami.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.shishigami.school.domain.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
	
	public GroupEntity findByGroupName(String groupName);

}
