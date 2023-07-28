package  ma.sir.ana.ws.dto;

import ma.sir.ana.zynerator.audit.Log;
import ma.sir.ana.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtilisateurDto  extends AuditBaseDto {

    private String email  ;
    private String name  ;




    public UtilisateurDto(){
        super();
    }



    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }






}
