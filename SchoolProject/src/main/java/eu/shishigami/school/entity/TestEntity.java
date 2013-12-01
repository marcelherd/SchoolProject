package eu.shishigami.school.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TestTable")
public class TestEntity implements Serializable {

	private static final long serialVersionUID = -1821614361923318880L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	private String name;

	public TestEntity() {
	}

}
