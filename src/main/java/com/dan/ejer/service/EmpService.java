package com.dan.ejer.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dan.ejer.entity.Employee;
import com.dan.ejer.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepository;
	
	public List<Employee> getAll() {
		return (List<Employee>) empRepository.findAll();
	}

	public String add(Employee emp) {
		String response;
		if (empRepository.save(emp) != null)
			response = "Succesfully added";
		else
			response = "Not added";
		return response;
	}

	public String edit(Employee emp) {
		String response;
		if (empRepository.save(emp) != null)
			response = "Succesfully updated";
		else
			response = "Not updated";
		return response;
	}

	public String delete(int emp_id) {
		String response;
		try {
			empRepository.deleteById(emp_id);
			response = "Succesfully deleted";
		}catch(IllegalArgumentException ex){
			response = "Not deleted" + ex;
		}
			
		return response;
	}

	public Map<String, Object> get(int pageNo, int pageSize) {
		Map<String, Object> response = new HashMap<String, Object>();
		Pageable pagable = PageRequest.of(pageNo, pageSize);
		Page<Employee> page = empRepository.findAll(pagable); 
		
		response.put("totalPage", page.getTotalPages());
		response.put("total", page.getTotalElements()); 
		response.put("currentPageNo", page.getNumber());
		response.put("data", page.getContent());
		
		return response;
	}

	public List<Employee> search(String searchword) {
		return empRepository.findByEmail(searchword);
	}
	
	public List<Employee> searchTwo(String searchword, int search) {
		return empRepository.findByEmailStartingWithOrSalary(searchword, search);
	}
	
	public List<Employee> searchWithQuery(String searchword) {
		return empRepository.findEmployee(searchword);
	}
	
	public List<Employee> searchWithNamedQuery(String searchword) {
		return empRepository.findEmployeeEmail(searchword);
	}
	

}
