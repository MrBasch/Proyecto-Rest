package cl.andres.utem.api.rest;

import cl.andres.utem.api.VO.ErrorVO;
import cl.andres.utem.api.persistence.model.pais;
import cl.andres.utem.api.persistence.repository.paisRepository;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces= MediaType.APPLICATION_JSON_VALUE)
public class apiREST {
    
    @Autowired
    private transient paisRepository paisRepository;
    
    @GetMapping(value = "/countries/{ISO2}/info", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity PaisByAlphaCode2(@PathVariable(name = "ISO2") String ISO2){
        
        if(StringUtils.isBlank(ISO2)){
            return new ResponseEntity(new ErrorVO("Datos Vacios"), HttpStatus.BAD_REQUEST);
        }
        
        String ISO2_upp = StringUtils.upperCase(StringUtils.trimToEmpty(ISO2));
        pais PaisResultado = paisRepository.findBycodealpha2(ISO2_upp);
        
        if( PaisResultado == null ){
            return new ResponseEntity(new ErrorVO(String.format("Datos no encontrados con el codifo %s",ISO2)),HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity(PaisResultado, HttpStatus.OK);
    }
    
    
    @GetMapping(value = "/countries/all", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity AllCounrties(){
        
        List<pais> ListaPaises = paisRepository.findAll();
        
        return new ResponseEntity(ListaPaises, HttpStatus.OK);
    }
    
    
    
}   
