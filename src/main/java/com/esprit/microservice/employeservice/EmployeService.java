package com.esprit.microservice.employeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {

	@Autowired
	private EmployeRepository employeRepository;

	public Employe addEmploye(Employe employe) {
		return employeRepository.save(employe);
	}
	public Employe updateEmploye(int id, Employe newEmploye) {
		if (employeRepository.findById(id).isPresent()) {
			Employe existingEmploye = employeRepository.findById(id).get();
			existingEmploye.setNom(newEmploye.getNom());
			existingEmploye.setPrenom(newEmploye.getPrenom());
			existingEmploye.setEmail(newEmploye.getEmail());

			return employeRepository.save(existingEmploye);
		} else
			return null;
	}
	public String deleteEmploye(int id) {
		if (employeRepository.findById(id).isPresent()) {
			employeRepository.deleteById(id);
			return "employé supprimé";
		} else
			return "employé non supprimé";
	}
}
