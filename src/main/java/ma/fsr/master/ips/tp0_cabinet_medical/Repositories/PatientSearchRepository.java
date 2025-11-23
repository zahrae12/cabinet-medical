package ma.fsr.master.ips.tp0_cabinet_medical.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ma.fsr.master.ips.tp0_cabinet_medical.Entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientSearchRepository {
    @PersistenceContext
    private EntityManager em;
    public List<Patient> searchByNameNative(String keyword) {
        String sql = """
SELECT * FROM patient
WHERE LOWER(nom) LIKE LOWER(CONCAT('%', :kw, '%'))
""";
        return em.createNativeQuery(sql, Patient.class)
                .setParameter("kw", keyword)
                .getResultList();
    }
}
