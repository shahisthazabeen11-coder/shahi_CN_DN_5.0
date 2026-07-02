package com.sample.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

//These are imported by using JPA

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
		
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String name;
 private String designation;
 private int age;
 private String city;
}
