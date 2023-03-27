package com.tig.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tig.ecomerce.model.StateType;

@Repository
public interface StateTypeRepository extends JpaRepository<StateType, Integer>{

}
