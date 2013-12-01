package eu.shishigami.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.shishigami.school.entity.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
	
}
