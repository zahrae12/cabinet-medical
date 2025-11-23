package ma.fsr.master.ips.tp0_cabinet_medical.Repositories;

import ma.fsr.master.ips.tp0_cabinet_medical.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNomContainingIgnoreCase(String nom);
}
