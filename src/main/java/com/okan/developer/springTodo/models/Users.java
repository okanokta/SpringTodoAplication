package com.okan.developer.springTodo.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String userName;
	String password;
	String email;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userName, password, email);
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", email=" + email + "]";
	}

}
