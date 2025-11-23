package ma.fsr.master.ips.tp0_cabinet_medical.Services;

import ma.fsr.master.ips.tp0_cabinet_medical.Entities.Patient;
import ma.fsr.master.ips.tp0_cabinet_medical.Repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public Patient createPatient(Patient p) {

        // 🔹 Validation 1 — nom obligatoire
        if (p.getNom() == null || p.getNom().isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire.");
        }

        // 🔹 Validation 2 — âge positif
        if (p.getAge() != null && p.getAge() < 0) {
            throw new IllegalArgumentException("L'âge doit être positif.");
        }

        // 🔹 Validation 3 — téléphone minimum 10 chiffres
        if (p.getTelephone() != null && p.getTelephone().length() < 10) {
            throw new IllegalArgumentException("Téléphone invalide.");
        }

        return repo.save(p);
    }

    public List<Patient> listPatients() {
        return repo.findAll();
    }
}
