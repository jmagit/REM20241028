package com.example.domains.entities;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the vets database table.
 * 
 */
@Entity
@Table(name="vets")
@NamedQuery(name="Vet.findAll", query="SELECT v FROM Vet v")
public class Vet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="first_name", length=30)
	private String firstName;

	@Column(name="last_name", length=30)
	private String lastName;

	//bi-directional many-to-many association to Specialty
	@ManyToMany(mappedBy="vets", fetch = FetchType.EAGER)
	private List<Specialty> specialties = new ArrayList<>();

	public Vet() {
	}

	public Vet(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Vet(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Specialty> getSpecialties() {
		return this.specialties;
	}

	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vet other = (Vet) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Veterinario [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}