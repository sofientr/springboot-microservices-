
package com.esprit.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entity.Reservation;
import com.esprit.microservice.service.ReservationService;

@RestController
@RequestMapping(value = "/api/reservation")
public class ReservationController {
	private String title = "Hello,I'm the reservation Microservice";
	@Autowired
	ReservationService reservationService;

	@RequestMapping("/hello")
	public String sayHello() {

		System.out.println(title);
		return title;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation a) {

		return new ResponseEntity<>(reservationService.addReservation(a), HttpStatus.OK);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Reservation>> getReservations() {

		return new ResponseEntity<>(reservationService.getAllReservation(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Reservation updateReservation(@PathVariable(value = "id") int id, @RequestBody Reservation a) {

		return reservationService.updateReservation(id, a);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteReservation(@PathVariable(value = "id") int id) {

		return new ResponseEntity<String>(reservationService.deleteReservation(id), HttpStatus.OK);
	}

}
