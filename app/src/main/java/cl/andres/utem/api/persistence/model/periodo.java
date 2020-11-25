package cl.andres.utem.api.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "periodo")
public class periodo extends Pkentitybase{
    
    @Column(name = "year", nullable = false)
        private Integer year = null;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
        
}
