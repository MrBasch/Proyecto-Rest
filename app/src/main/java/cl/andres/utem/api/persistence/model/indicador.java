package cl.andres.utem.api.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "indicador")
public class indicador extends Pkentitybase{
    
    @Column(name = "nombre" ,nullable = false)
        private String nombre = null;
    
    @Column(name = "unit" ,nullable = false)
        private String unit = null;
    
    @Column(name = "descripcion" ,nullable = false)
        private String descripcion = null;
    
    @Column(name = "cod" ,nullable = false)
        private String cod = null;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
    
}
