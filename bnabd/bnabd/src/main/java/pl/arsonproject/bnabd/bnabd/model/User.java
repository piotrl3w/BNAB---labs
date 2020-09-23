package pl.arsonproject.bnabd.bnabd.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class User extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstname",nullable = false)
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private UserRole role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Course> courseList;

	public User( String firstName, String lastName, String email, String password, UserRole role, List<Course> itemList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.courseList = itemList;
	}
}
