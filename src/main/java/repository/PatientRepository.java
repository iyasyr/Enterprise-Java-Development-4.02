package repository;

import model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDateOfBirthBetween(LocalDate start, LocalDate end);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.department = :department")
    List<Patient> findByDoctorDepartment(@Param("department") String department);

    @Query("SELECT p FROM Patient p WHERE p.admittedBy.status = 'OFF'")
    List<Patient> findByDoctorWithOffStatus();
}
