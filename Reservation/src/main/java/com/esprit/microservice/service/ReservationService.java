/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entity.Reservation;
import com.esprit.microservice.repository.ReservationRepository;

/**
 * {@link } class.
 *
 * @author Dhia
 * @since 0.1.0
 */
@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;

	public Reservation addReservation(Reservation a) {

		return reservationRepository.save(a);

	}

	public List<Reservation> getAllReservation() {

		return reservationRepository.findAll();
	}

	public String deleteReservation(int id) {

		if (reservationRepository.findById(id).isPresent()) {
			reservationRepository.deleteById(id);
			return "reservation supprimé";
		}
		else
			return " reservation non supprimé";
	}

	public Reservation updateReservation(int id, Reservation a) {

		if (reservationRepository.findById(id).isPresent()) {
			Reservation existingReservation = reservationRepository.findById(id).get();
			existingReservation.setDateReservation(a.getDateReservation());
			existingReservation.setDuree(a.getDuree());
			return reservationRepository.save(existingReservation);

		}
		else
			return null;

	}

}
