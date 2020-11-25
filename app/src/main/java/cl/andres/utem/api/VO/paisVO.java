package cl.andres.utem.api.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class paisVO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String codealpha2 = null;
    private String codealpha3 = null;
    private String currencycode = null;
    private String currencyname = null;
    private String Lang = null;
    private String nombre = null;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String Lang) {
        this.Lang = Lang;
    }
   
    
    
    
}
