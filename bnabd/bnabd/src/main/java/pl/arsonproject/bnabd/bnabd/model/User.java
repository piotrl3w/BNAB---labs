package pl.arsonproject.bnabd.bnabd.model;

import javax.persistence.*;

import java.lang.reflect.Constructor;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public User(){

	}

	public User(String firstName, String lastName, String email, String password, UserRole role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		//this.role = role;
	}

	

}
