package pl.arsonproject.bnabd.bnabd.model;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	private String title;
	private String description;


	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}