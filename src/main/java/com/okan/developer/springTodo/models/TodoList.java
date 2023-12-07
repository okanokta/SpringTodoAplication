package com.okan.developer.springTodo.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="todo_list")
@NoArgsConstructor
public class TodoList implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="todo_id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="comleted")
	private Boolean completed;
	
	
	
	public String toString() {
		return String.format("TodoList{id=%d, title=%s, description=%s, date=%s, priority=%s, completed=%s}",
				id,title,description,date,priority,completed);
	}
}
