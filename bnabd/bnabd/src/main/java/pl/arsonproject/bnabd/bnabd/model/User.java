package pl.arsonproject.bnabd.bnabd.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	//private UserRole role;




	public User(String firstName, String lastName, String email, String password, UserRole role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		//this.role = role;
	}
}
