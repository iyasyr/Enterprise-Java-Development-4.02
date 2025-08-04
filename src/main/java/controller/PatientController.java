package controller;

import lombok.RequiredArgsConstructor;
import model.Patient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dob")
    public List<Patient> getByDobRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }

    @GetMapping("/department/{dept}")
    public List<Patient> getByDoctorDepartment(@PathVariable String dept) {
        return patientRepository.findByDoctorDepartment(dept);
    }

    @GetMapping("/doctor-status/off")
    public List<Patient> getByDoctorWithOffStatus() {
        return patientRepository.findByDoctorWithOffStatus();
    }
}

