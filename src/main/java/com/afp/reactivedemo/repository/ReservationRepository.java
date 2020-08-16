package com.afp.reactivedemo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.afp.reactivedemo.domains.Reservation;

/**
 * <p>
 *  
 * </p>
 * 
 * @author Andrés Felipe Posada Ramírez.
 * @since Aug 16, 2020 1:41:13 PM
 * @version 1.0
 *
 */
public interface ReservationRepository extends ReactiveCrudRepository<Reservation, String> {

}
