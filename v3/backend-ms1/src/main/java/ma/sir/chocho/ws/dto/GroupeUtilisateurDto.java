package  ma.sir.chocho.ws.dto;

import ma.sir.chocho.zynerator.audit.Log;
import ma.sir.chocho.zynerator.dto.AuditBaseDto;
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
