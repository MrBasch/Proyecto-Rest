package cl.andres.utem.api.dto;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;


public class CmdDTO implements Serializable{
    
    private static final long SerialVersionUID = 1L;
     
    private Integer exitCode = null;
    private String output = null;
    private String error = null;
    
    public CmdDTO(){
        this.exitCode = -99;
        this.output = StringUtils.EMPTY;
        this.error = StringUtils.EMPTY;
    }
    
    public CmdDTO(Integer exitCode, String output, String error){
        this.exitCode=exitCode;
        this.output=output;
        this.error = error;        
    }
    
    
}