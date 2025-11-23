package ma.fsr.master.ips.tp0_cabinet_medical.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ma.fsr.master.ips.tp0_cabinet_medical.Entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientSearchRepositoryJpql {

    @PersistenceContext
    private EntityManager em;

    public List<Patient> searchByNameJpql(String keyword) {
        String jpql = """
            SELECT p FROM Patient p
            WHERE LOWER(p.nom) LIKE LOWER(CONCAT('%', :kw, '%'))
        """;
        return em.createQuery(jpql, Patient.class)
                .setParameter("kw", keyword)
                .getResultList();
    }
}
