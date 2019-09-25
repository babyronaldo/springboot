package springboot.hibernate.entity;
// Generated Dec 12, 2016 1:49:28 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Candidate generated by hbm2java
 */
@Entity
@Table(name = "candidate", catalog = "interviewtracking")
public class Candidate implements java.io.Serializable
{

	private Integer candidateId;
	private String name;
	private String skill;
	private String uniName;
	private float gpa;
	private String graduateYear;
	private Date dayOfBirth;
	private String email;
	private int phone;
	private String address;
	private String degree;
	private Set<Interview> interviews = new HashSet<Interview>(0);
	private Boolean isDeleted;

	public Candidate()
	{
	}

	public Candidate(String name, String skill, String uniName, float gpa, String graduateYear, Date dayOfBirth,
			String email, int phone, String address, String degree)
	{
		this.name = name;
		this.skill = skill;
		this.uniName = uniName;
		this.gpa = gpa;
		this.graduateYear = graduateYear;
		this.dayOfBirth = dayOfBirth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.degree = degree;
	}

	public Candidate(String name, String skill, String uniName, float gpa, String graduateYear, Date dayOfBirth,
			String email, int phone, String address, String degree, Set<Interview> interviews)
	{
		this.name = name;
		this.skill = skill;
		this.uniName = uniName;
		this.gpa = gpa;
		this.graduateYear = graduateYear;
		this.dayOfBirth = dayOfBirth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.degree = degree;
		this.interviews = interviews;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "candidateId", unique = true, nullable = false)
	public Integer getCandidateId()
	{
		return this.candidateId;
	}

	public void setCandidateId(Integer candidateId)
	{
		this.candidateId = candidateId;
	}

	@NotEmpty
	@Column(name = "name", nullable = false, length = 50)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@NotEmpty
	@Column(name = "skill", nullable = false, length = 100)
	public String getSkill()
	{
		return this.skill;
	}

	public void setSkill(String skill)
	{
		this.skill = skill;
	}

	@NotEmpty
	@Column(name = "uniName", nullable = false, length = 100)
	public String getUniName()
	{
		return this.uniName;
	}

	public void setUniName(String uniName)
	{
		this.uniName = uniName;
	}

	// @NotNull
	@Column(name = "gpa", nullable = false, precision = 12, scale = 0)
	public float getGpa()
	{
		return this.gpa;
	}

	public void setGpa(float gpa)
	{
		this.gpa = gpa;
	}

	@NotEmpty
	@Column(name = "graduateYear", nullable = false, length = 4)
	public String getGraduateYear()
	{
		return this.graduateYear;
	}

	public void setGraduateYear(String graduateYear)
	{
		this.graduateYear = graduateYear;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dayOfBirth", nullable = false, length = 10)
	public Date getDayOfBirth()
	{
		return this.dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth)
	{
		this.dayOfBirth = dayOfBirth;
	}

	@NotEmpty
	@Column(name = "email", nullable = false, length = 100)
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@NotNull
	@Column(name = "phone", nullable = false)
	public int getPhone()
	{
		return this.phone;
	}

	public void setPhone(int phone)
	{
		this.phone = phone;
	}

	@NotEmpty
	@Column(name = "address", nullable = false, length = 250)
	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@NotEmpty
	@Column(name = "degree", nullable = false, length = 20)
	public String getDegree()
	{
		return this.degree;
	}

	public void setDegree(String degree)
	{
		this.degree = degree;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")//, cascade = CascadeType.ALL)
	// //
	// cascade=CascadeType.ALL,
	public Set<Interview> getInterviews()
	{
		return this.interviews;
	}

	public void setInterviews(Set<Interview> interviews)
	{
		this.interviews = interviews;
	}

	@Column(name = "isDeleted")
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		isDeleted = isDeleted;
	}
}
