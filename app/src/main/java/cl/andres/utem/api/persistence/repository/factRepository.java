package cl.andres.utem.api.persistence.repository;

import cl.andres.utem.api.persistence.model.fact;
import cl.andres.utem.api.persistence.model.pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface factRepository extends JpaRepository<fact, Long>{
    
   
}
