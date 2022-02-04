package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Page<EmployeeDTO> findAll(Pageable pageable){
        Page<Employee> page = employeeRepository.findAll(pageable);
        return page.map(x -> new EmployeeDTO(x));

    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO employeeDTO){
        Employee entity = new Employee();
        entity.setName(employeeDTO.getName());
        entity.setEmail(employeeDTO.getEmail());
        entity.setName(employeeDTO.getName());
        entity.setDepartment(new Department(employeeDTO.getDepartmentId(), null));
        employeeRepository.save(entity);
        EmployeeDTO dto = new EmployeeDTO(entity);
        return dto;


    }
}
