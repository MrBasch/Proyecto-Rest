package cl.andres.utem.api.persistence.repository;

import cl.andres.utem.api.persistence.model.indicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface indicadorRepository extends JpaRepository< indicador, Long>{
    
    public indicador findByCod(String cod);
    
}
