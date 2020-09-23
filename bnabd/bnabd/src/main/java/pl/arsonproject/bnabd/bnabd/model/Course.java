package pl.arsonproject.bnabd.bnabd.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EnableAutoConfiguration
@Table(appliesTo = "Course")
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