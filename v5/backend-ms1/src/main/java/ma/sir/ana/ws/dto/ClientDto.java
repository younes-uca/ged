package  ma.sir.ana.ws.dto;

import ma.sir.ana.zynerator.audit.Log;
import ma.sir.ana.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto  extends AuditBaseDto {

    private String fullName  ;
    private String email  ;
    private String dateRegistration ;
    private BigDecimal nombreEnfant  ;

    private ClientCategoryDto clientCategory ;



    public ClientDto(){
        super();
    }



    @Log
    public String getFullName(){
        return this.fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateRegistration(){
        return this.dateRegistration;
    }
    public void setDateRegistration(String dateRegistration){
        this.dateRegistration = dateRegistration;
    }

    @Log
    public BigDecimal getNombreEnfant(){
        return this.nombreEnfant;
    }
    public void setNombreEnfant(BigDecimal nombreEnfant){
        this.nombreEnfant = nombreEnfant;
    }


    public ClientCategoryDto getClientCategory(){
        return this.clientCategory;
    }

    public void setClientCategory(ClientCategoryDto clientCategory){
        this.clientCategory = clientCategory;
    }




}
