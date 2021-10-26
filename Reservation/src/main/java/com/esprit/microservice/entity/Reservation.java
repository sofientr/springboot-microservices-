/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Entity

public class Reservation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3090249096008711398L;
	@Id
	@GeneratedValue
	private int id;
	private int duree;
	private Date dateReservation;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDuree() {
		return duree;
	}



	public void setDuree(int duree) {
		this.duree = duree;
	}



	public Date getDateReservation() {
		return dateReservation;
	}



	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Reservation(int id, int duree, Date dateReservation) {
		super();
		this.id = id;
		this.duree = duree;
		this.dateReservation = dateReservation;
	}



	public Reservation() {

		super();
	}

}
