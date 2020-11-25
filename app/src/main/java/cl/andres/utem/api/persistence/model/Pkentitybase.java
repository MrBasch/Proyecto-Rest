package cl.andres.utem.api.persistence.model;

import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@MappedSuperclass
public class Pkentitybase implements Serializable {
    
    private static final long SerialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "pk" , nullable = false)
    private Long id = null;
    
    
    @Override
    public String toString() {
        return  ReflectionToStringBuilder.toString(this,ToStringStyle.JSON_STYLE);
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pkentitybase other = (Pkentitybase) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
