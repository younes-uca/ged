package  ma.sir.easy.ws.dto;

import ma.sir.easy.zynerator.audit.Log;
import ma.sir.easy.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcessShareDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;




    public AcessShareDto(){
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
