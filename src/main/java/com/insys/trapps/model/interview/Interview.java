package com.insys.trapps.model.interview;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.insys.trapps.model.Person;
import com.insys.trapps.model.Role;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "INTERVIEW")
@EqualsAndHashCode(of = { "candidate", "role", "date" }, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@SuppressFBWarnings(value = { "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class Interview implements Serializable {

	private static final long serialVersionUID = 898931233669153755L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	@Column(nullable = false)
	private Date date;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String phone;

	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name = "PERSON_ID")
	private Person candidate;

	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	@Getter
	@Setter
	@ManyToMany(targetEntity = Person.class, cascade = CascadeType.MERGE)
	private Set<Person> interviewers;

	@Getter
	@Setter
	@OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL, orphanRemoval=true)
	@OrderBy("QUESTION_ID ASC")
	private Set<Answer> answers;

	@Getter
	@Setter
	@OneToMany(targetEntity = Feedback.class, cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Feedback> feedbacks;

}
