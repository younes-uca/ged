package  ma.sir.chocho.ws.dto;

import ma.sir.chocho.zynerator.audit.Log;
import ma.sir.chocho.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;




    public TagDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }






}
