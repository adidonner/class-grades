package app.core.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id"})
@ToString(exclude = {"grades" })
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private Date birthday;
	private Boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	@Size(max=3)
	private List<Grade> grades;

	public void addGrade(Grade grade) {
		if (this.grades == null) {
			this.grades = new ArrayList<>();
		}

		this.grades.add(grade);

	}
}
