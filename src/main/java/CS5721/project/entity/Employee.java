package CS5721.project.entity;

//@Entity
//@Table(name = "employee")
public class Employee extends Person {

	// @Id
	// @Column(name = "id", unique = true)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Column(name = "employeeNum")
	private int employeeNum;

}
