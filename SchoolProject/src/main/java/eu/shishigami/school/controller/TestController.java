package eu.shishigami.school.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.entity.TestEntity;
import eu.shishigami.school.service.TestService;

@Component
@Scope(value = "session")
public class TestController implements Serializable {

	private static final long serialVersionUID = 4485640685691038740L;

	@Autowired
	private TestService testService;

	public void handleTest() {
		for (int i = 0; i < 10; i++) {
			TestEntity testEntity = new TestEntity();
			testEntity.setName("Entity #" + i);
			TestEntity persisted = testService.save(testEntity);
		}
	}

}
