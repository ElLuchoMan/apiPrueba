package com.dan.ejer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.ejer.entity.Employee;
import com.dan.ejer.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/emp")
@Api(tags = {"CRUD EMPLEADOS"})
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/get/all")
	@ApiOperation(value = "Metodo que trae info de todos los empleados")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Succesfull")
	})
	public List<Employee> getAll(){ 
		return empService.getAll();
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "Metodo que agrega un empleado")
	public String add(@RequestBody Employee emp){
		return empService.add(emp);
	}
	
	@PutMapping("/edit")
	@ApiOperation(value = "Metodo que actualiza el email de un empleado")
	public String edit(@RequestBody Employee emp){
		return empService.edit(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Metodo que elimina un empleado")
	public String delete(@PathVariable("id") int emp_id){
		return empService.delete(emp_id);
	}
	
	@GetMapping("/get/page")
	@ApiOperation(value = "Metodo que trae info de la cantidad de empleados que le digamos en paginas")
	public Map<String, Object> get(@RequestParam (value = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam (value = "pageSize", required = false, defaultValue = "3") int pageSize){ 
		return empService.get(pageNo, pageSize);
	}
	
	@GetMapping("/get/search")
	@ApiOperation(value = "Metodo que trae info de los empleados a traves de un campo especifico")
	public List<Employee> search(@RequestParam(value = "searchword") String searchword) { 
		return empService.search(searchword);
	}
	
	@GetMapping("/get/searchTwo")
	@ApiOperation(value = "Metodo que trae info de los empleados cuyo email o salary concuerden")
	public List<Employee> searchTwo(@RequestParam(value = "searchword") String searchword,
			@RequestParam(value = "search", required = false, defaultValue = "0") int search) { 
		return empService.searchTwo(searchword, search);
	}
	
	@GetMapping("/get/searchThree")
	@ApiOperation(value = "Metodo que trae info de los empleados sin importar la mayuscula")
	public List<Employee> searchWithQuery(@RequestParam(value = "searchword") String searchword) { 
		return empService.searchWithQuery(searchword);
	}
	
	@GetMapping("/get/searchFour")
	@ApiOperation(value = "Metodo que trae info de los empleados que tienen un email parecido a..")
	public List<Employee> searchWithNamedQuery(@RequestParam(value = "searchword") String searchword) { 
		return empService.searchWithNamedQuery(searchword);
	}
}
