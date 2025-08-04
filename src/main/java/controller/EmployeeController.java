package controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import model.Employee;
import model.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class EmployeeController {

    @PostConstruct
    public void init() {
        System.out.println("✅ EmployeeController loaded!");
    }

    private final EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getDoctorById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public List<Employee> getByStatus(@PathVariable Status status) {
        return employeeRepository.findByStatus(status);
    }

    @GetMapping("/department/{dept}")
    public List<Employee> getByDepartment(@PathVariable String dept) {
        return employeeRepository.findByDepartment(dept);
    }
}
