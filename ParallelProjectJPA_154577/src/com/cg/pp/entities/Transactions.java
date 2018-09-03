package com.cg.pp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transactions {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int id;
	@Column(name = "MOBILENO")
	public String mobileno;
	@Column(name = "TYPE")
	public String message;

	public Transactions() {
		id = -1;
		mobileno = message = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "" + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
