package me.app.component;

import me.app.aircraft.domain.Aircraft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ComponentRepo extends CrudRepository<Component,Integer> {}

