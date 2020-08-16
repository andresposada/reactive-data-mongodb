package com.afp.reactivedemo.init;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.afp.reactivedemo.domains.Reservation;
import com.afp.reactivedemo.repository.ReservationRepository;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

/**
 * <p>
 * 
 * </p>
 * 
 * @author Andrés Felipe Posada Ramírez.
 * @since Aug 16, 2020 1:46:13 PM
 * @version 1.0
 *
 */
@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log4j2
public class SampleDataInitializer {

  final ReservationRepository reservationRepo;

  @EventListener(ApplicationReadyEvent.class)
  public void ready() {
    Flux<Reservation> reservations = Flux.just("Andrés", "Carlos", "Mauricio", "José", "Juan", "Esteban", "Felipe")
        .map(name -> new Reservation(null, name)).flatMap(this.reservationRepo::save);
    
    this.reservationRepo
    .deleteAll()
    .thenMany(reservations)
    .thenMany(this.reservationRepo.findAll())
    .subscribe(log::info);
    
  }

}
