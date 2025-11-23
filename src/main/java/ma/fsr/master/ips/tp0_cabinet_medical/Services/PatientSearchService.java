package ma.fsr.master.ips.tp0_cabinet_medical.Services;

import ma.fsr.master.ips.tp0_cabinet_medical.Entities.Patient;
import ma.fsr.master.ips.tp0_cabinet_medical.Repositories.PatientRepository;
import ma.fsr.master.ips.tp0_cabinet_medical.Repositories.PatientSearchRepository;
import ma.fsr.master.ips.tp0_cabinet_medical.Repositories.PatientSearchRepositoryJpql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientSearchService {

    private final PatientRepository springRepo;
    private final PatientSearchRepositoryJpql jpqlRepo;
    private final PatientSearchRepository sqlRepo;

    public PatientSearchService(
            PatientRepository springRepo,
            PatientSearchRepositoryJpql jpqlRepo,
            PatientSearchRepository sqlRepo
    ) {
        this.springRepo = springRepo;
        this.jpqlRepo = jpqlRepo;
        this.sqlRepo = sqlRepo;
    }

    public List<Patient> searchSpring(String k) {
        return springRepo.findByNomContainingIgnoreCase(k);
    }

    public List<Patient> searchJpql(String k) {
        return jpqlRepo.searchByNameJpql(k);
    }

    public List<Patient> searchSql(String k) {
        return sqlRepo.searchByNameNative(k);
    }
}
