package CS5721.project.entity.person;

import CS5721.project.entity.wage.Wage;

public class Person {

	private Long id;

	private String name;

	private Wage wage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWage() {
		return wage.getWage();
	}

}