package me.app.flight;

import me.app.aircraft.domain.Aircraft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface FlightRepo extends CrudRepository<Flight,Integer> {}

