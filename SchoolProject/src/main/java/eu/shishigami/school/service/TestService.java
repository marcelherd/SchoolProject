package eu.shishigami.school.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.shishigami.school.entity.TestEntity;
import eu.shishigami.school.repository.TestRepository;

@Service
public class TestService implements Serializable {

	private static final long serialVersionUID = 5415441437226596914L;
	
	@Autowired
	private TestRepository testRepository;
	
	public TestEntity save(final TestEntity testEntity) {
		return testRepository.save(testEntity);
	}
	
}
