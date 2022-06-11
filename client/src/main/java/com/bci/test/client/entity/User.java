package com.bci.test.client.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="\"users\"")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_users")
    @SequenceGenerator(name = "sec_users", sequenceName = "sec_users", allocationSize = 1)
	private Integer id;
	
	@Column(name = "\"name\"")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "\"password\"")
	private String pwd;
	
	@Column(name = "created")
	private Date createdDate;
	
	@Column(name = "modified")
	private Date modifiedDate;
	
	@Column(name = "lastlogin")
	private Date lastLoginDate;
	
	@Column(name = "isactive")
	private String isactiveStatus;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
	private List<Phones> phones;
}
