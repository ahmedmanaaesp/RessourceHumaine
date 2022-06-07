package com.esprit.microservice.employeservice;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	@Query("select e from Employe e where e.nom like :nom")
	public Page<Employe> employeByNom(@Param("nom") String n, Pageable pageable);
	   
}
