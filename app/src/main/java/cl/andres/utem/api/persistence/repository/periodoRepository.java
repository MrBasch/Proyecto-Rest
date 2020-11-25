package cl.andres.utem.api.persistence.repository;

import cl.andres.utem.api.persistence.model.periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface periodoRepository extends JpaRepository<periodo, Long>{
    
}
