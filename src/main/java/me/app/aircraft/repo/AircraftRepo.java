package me.app.aircraft.repo;

import me.app.aircraft.domain.Aircraft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AircraftRepo extends CrudRepository<Aircraft,Integer> {}
//@Repository
//public interface AircraftRepo extends JpaRepository<Aircraft,Integer> {}
