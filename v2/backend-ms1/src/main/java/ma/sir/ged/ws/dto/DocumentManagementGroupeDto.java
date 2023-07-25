package  ma.sir.ged.ws.dto;

import ma.sir.ged.zynerator.audit.Log;
import ma.sir.ged.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentManagementGroupeDto  extends AuditBaseDto {

    private String dateManagement ;

    private DocumentDto document ;
    private GroupeDto groupe ;
    private AcessManagementDto acessManagement ;



    public DocumentManagementGroupeDto(){
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
    public GroupeDto getGroupe(){
        return this.groupe;
    }

    public void setGroupe(GroupeDto groupe){
        this.groupe = groupe;
    }
    public AcessManagementDto getAcessManagement(){
        return this.acessManagement;
    }

    public void setAcessManagement(AcessManagementDto acessManagement){
        this.acessManagement = acessManagement;
    }




}
