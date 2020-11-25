package cl.andres.utem.api.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class pais extends Pkentitybase{
    
    @Column(name = "codealpha2", nullable=false)
        private String codealpha2 = null;
    
    @Column(name = "codealpha3", nullable=false)
        private String codealpha3 = null;
    
    @Column(name = "currencycode", nullable=false)
        private String currencycode = null;
    
    @Column(name = "currencyname", nullable=false)
        private String currencyname = null;
    
    @Column(name = "Lang", nullable=false)
        private String Lang = null;
    
    @Column(name = "nombre", nullable=false)
        private String nombre = null;

    public String getCodealpha2() {
        return codealpha2;
    }

    public void setCodealpha2(String codealpha2) {
        this.codealpha2 = codealpha2;
    }

    public String getCodealpha3() {
        return codealpha3;
    }

    public void setCodealpha3(String codealpha3) {
        this.codealpha3 = codealpha3;
    }

    public String getCurrencyCode() {
        return currencycode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencycode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyname;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyname = currencyName;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String Lang) {
        this.Lang = Lang;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
