package  ma.sir.ged.ws.dto;

import ma.sir.ged.zynerator.audit.Log;
import ma.sir.ged.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntiteAdministrativeDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;

    private UtilisateurDto utilisateur ;



    public EntiteAdministrativeDto(){
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


    public UtilisateurDto getUtilisateur(){
        return this.utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur){
        this.utilisateur = utilisateur;
    }




}
