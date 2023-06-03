package com.sharad2code.restapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is entity class consists Employee table attributes
 *
 * @author SharVish
 * @since 0.1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;
    private String empAddress;
    private Long age;
    private Double salary;
}
