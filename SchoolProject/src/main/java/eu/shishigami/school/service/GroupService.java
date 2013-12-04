package eu.shishigami.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.repository.GroupRepository;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository groupRepository;

	@Transactional(readOnly = false)
	public void delete(final GroupEntity groupEntity) {
		groupRepository.delete(groupEntity);
	}
	
	@Transactional(readOnly = false)
	public GroupEntity save(final GroupEntity groupEntity) {
		return groupRepository.save(groupEntity);
	}
	
	public GroupEntity findByGroupName(final String groupName) {
		return groupRepository.findByGroupName(groupName);
	}

	public GroupEntity findOne(final Long id) {
		return groupRepository.findOne(id);
	}
	
	public List<GroupEntity> findAll() {
		return groupRepository.findAll();
	}

}
