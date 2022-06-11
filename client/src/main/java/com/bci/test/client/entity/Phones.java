package com.bci.test.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"phones\"")
public class Phones {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_phones")
    @SequenceGenerator(name = "sec_phones", sequenceName = "sec_phones", allocationSize = 1)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "citycode")
	private String citycode;
	
	@Column(name = "contrycode")
	private String contrycode;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	@JsonIgnore
	private User user;

	public Phones(String number, String citycode, String contrycode, User user) {
		super();
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
		this.user = user;
	}
	
	
	
}
