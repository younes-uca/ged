package  ma.sir.ana.ws.dto;

import ma.sir.ana.zynerator.audit.Log;
import ma.sir.ana.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupeUtilisateurDto  extends AuditBaseDto {


    private GroupeDto groupe ;
    private UtilisateurDto utilisateur ;



    public GroupeUtilisateurDto(){
        super();
    }




    public GroupeDto getGroupe(){
        return this.groupe;
    }

    public void setGroupe(GroupeDto groupe){
        this.groupe = groupe;
    }
    public UtilisateurDto getUtilisateur(){
        return this.utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur){
        this.utilisateur = utilisateur;
    }




}
