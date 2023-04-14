package com.Todo.Todo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="first_ruhe_demo")
@NoArgsConstructor
@Getter
@Setter
public class UserEntities {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="about", nullable=false, length=200)
	private String about;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marital_id", referencedColumnName = "marital_status_id")
    private MaritalStatusEntities maritalSataus;
    
    @OneToMany(targetEntity = EducationEntities.class, mappedBy = "userEntities", cascade = CascadeType.ALL)
	private List<EducationEntities> educations;
    
//	@JsonIgnore
//    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinTable(name = "user_project",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "project_id"))
//    private Set<ProjectEntities> projectEntities;

	@JsonIgnore
    @OneToMany(targetEntity = UserProjectXref.class, mappedBy = "userEntities", cascade = CascadeType.ALL)
    private List<UserProjectXref> userProject;
    
}

