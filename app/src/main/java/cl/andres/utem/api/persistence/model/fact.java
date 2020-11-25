package cl.andres.utem.api.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fact")
public class fact extends Pkentitybase{
    
    @ManyToOne
    @JoinColumn(name = "fk_periodo", referencedColumnName = "pk", nullable = false)
        private periodo Periodo = null;
    
   @ManyToOne
   @JoinColumn(name = "fk_pais", referencedColumnName = "pk", nullable = false)
        private pais Pais = null;
   
   @ManyToOne
   @JoinColumn(name = "fk_indicador", referencedColumnName = "pk", nullable = false)
        private indicador Indicador = null;
   
   @Column(name = "Valor", nullable = false)
        private Float valor = null;
    
}
