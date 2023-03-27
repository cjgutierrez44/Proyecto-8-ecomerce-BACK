package com.tig.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tig.ecomerce.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
