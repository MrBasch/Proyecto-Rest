package cl.andres.utem.api.persistence.repository;

import cl.andres.utem.api.persistence.model.pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paisRepository extends JpaRepository<pais, Long>{
        
    public pais findBycodealpha2(String codealpha2);
    
    public List<pais> findAll();
    
}
