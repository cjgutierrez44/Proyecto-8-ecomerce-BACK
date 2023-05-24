package com.tig.ecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tig.ecomerce.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
	@Query("SELECT i FROM Invoice i WHERE user.id = ?1 ORDER BY i.id DESC")
	List<Invoice> getInvoicesByUserId(int id);
}
