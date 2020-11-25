package cl.andres.utem.api.utils;

import cl.andres.utem.api.dto.CmdDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CmdUtils implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CmdUtils.class);
    
    private CmdUtils(){
        throw new IllegalStateException();
    }
    
    public static CmdDTO execute(final String cmd){
        
       CmdDTO dto = new CmdDTO(-99, "Error", "Error");
       try{
           if(StringUtils.isNotBlank(cmd)){
               LOGGER.debug("===Iniciando ejecucion de '{}' ===",cmd);
               Process process = Runtime.getRuntime().exec(cmd);
               if(process != null){
                   LOGGER.debug("Ejecutando: '{}'",cmd);
                   BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                   BufferedReader bufferError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                   Integer exitCode = process.waitFor();
                   
                   StringBuilder sb = new StringBuilder();
                   String line = StringUtils.EMPTY;
                   while((line = buffer.readLine()) != null ){
                        sb.append(line);
                   }
                   String output = StringUtils.trimToEmpty(sb.toString());
                   
                   sb = new StringBuilder();
                   line = StringUtils.EMPTY;
                   while( (line = bufferError.readLine()) != null){
                        sb.append(line);
                   }
                   String error = StringUtils.trimToEmpty(sb.toString());
                   
                   LOGGER.debug("Salida del comando: '{}'",output);
                   if(StringUtils.isNotBlank(error)){
                       LOGGER.error("Codifo de salida: {} Mensaje de error: {}",exitCode,error);
                   }
                   dto = new CmdDTO(exitCode,output,error);
               }   
               LOGGER.debug("=== Finalizando ejecucion de '{}' ===",cmd);
           }
       }catch(Exception e){
                   dto = new CmdDTO(-99,"Error", e.getMessage());
                   LOGGER.error("Error al ejecutar comando: {}",e.getMessage());
                   LOGGER.debug("Error al ejecutar comando: {}",e.getMessage(),e);
                   }
        
       return dto;
    }
    
}
