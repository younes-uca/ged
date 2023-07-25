package  ma.sir.ged.ws.dto;

import ma.sir.ged.zynerator.audit.Log;
import ma.sir.ged.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentManagementUtilisateurDto  extends AuditBaseDto {

    private String dateManagement ;

    private DocumentDto document ;
    private UtilisateurDto utilisateur ;
    private AcessManagementDto acessManagement ;



    public DocumentManagementUtilisateurDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateManagement(){
        return this.dateManagement;
    }
    public void setDateManagement(String dateManagement){
        this.dateManagement = dateManagement;
    }


    public DocumentDto getDocument(){
        return this.document;
    }

    public void setDocument(DocumentDto document){
        this.document = document;
    }
    public UtilisateurDto getUtilisateur(){
        return this.utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur){
        this.utilisateur = utilisateur;
    }
    public AcessManagementDto getAcessManagement(){
        return this.acessManagement;
    }

    public void setAcessManagement(AcessManagementDto acessManagement){
        this.acessManagement = acessManagement;
    }




}
