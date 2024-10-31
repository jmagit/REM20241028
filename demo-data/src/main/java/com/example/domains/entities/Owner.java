package com.example.domains.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

import com.example.core.domains.entities.EntityBase;
import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the owners database table.
 * 
 */
@Entity
@Table(name="owners")
@NamedQuery(name="Owner.findAll", query="SELECT o FROM Owner o")
public class Owner extends EntityBase<Owner> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String address;

	@Column(length=80)
	private String city;

	@Column(name="first_name", length=30)
	@NotBlank
	@Size(min=2, max=9)
	private String firstName;

	@Column(name="last_name", length=30)
	@NotBlank
	@Size(min=2, max=30)
	private String lastName;

	@Column(length=20)
	private String telephone;

	//bi-directional many-to-one association to Pet
	@OneToMany(mappedBy="owner", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Pet> pets;

	public Owner() {
	}

	public Owner(@NotBlank @Size(min = 2, max = 30) String firstName,
			@NotBlank @Size(min = 2, max = 30) String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Pet> getPets() {
		return this.pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Pet addPet(Pet pet) {
		getPets().add(pet);
		pet.setOwner(this);

		return pet;
	}

	public Pet removePet(Pet pet) {
		getPets().remove(pet);
		pet.setOwner(null);

		return pet;
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
		Owner other = (Owner) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", address=" + address + ", city=" + city + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", telephone=" + telephone + "]";
	}

}