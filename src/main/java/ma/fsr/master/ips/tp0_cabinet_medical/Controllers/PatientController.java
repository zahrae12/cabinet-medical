package ma.fsr.master.ips.tp0_cabinet_medical.Controllers;

import ma.fsr.master.ips.tp0_cabinet_medical.Entities.Patient;
import ma.fsr.master.ips.tp0_cabinet_medical.Services.PatientService;
import ma.fsr.master.ips.tp0_cabinet_medical.Services.PatientSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;
    private final PatientSearchService searchService;

    public PatientController(PatientService patientService, PatientSearchService searchService) {
        this.patientService = patientService;
        this.searchService = searchService;
    }

    // ----------- Ajouter un patient ----------
    @PostMapping
    public Patient create(@RequestBody Patient p) {
        return patientService.createPatient(p);
    }

    // ----------- Lister les patients ----------
    @GetMapping
    public List<Patient> getAll() {
        return patientService.listPatients();
    }

    // ----------- Recherche : Spring Data ----------
    @GetMapping("/search/spring")
    public List<Patient> searchSpring(@RequestParam String k) {
        return searchService.searchSpring(k);
    }

    // ----------- Recherche : JPQL ----------
    @GetMapping("/search/jpql")
    public List<Patient> searchJpql(@RequestParam String k) {
        return searchService.searchJpql(k);
    }

    // ----------- Recherche : SQL natif ----------
    @GetMapping("/search/sql")
    public List<Patient> searchSql(@RequestParam String k) {
        return searchService.searchSql(k);
    }
}
