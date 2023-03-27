package com.tig.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tig.ecomerce.model.StreetType;

@Repository
public interface StreetTypeRepository extends JpaRepository<StreetType, Integer>{

}
