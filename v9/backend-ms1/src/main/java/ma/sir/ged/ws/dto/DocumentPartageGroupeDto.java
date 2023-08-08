package  ma.sir.ged.ws.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ma.sir.ged.zynerator.audit.Log;
import ma.sir.ged.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import ma.sir.ged.zynerator.util.LocalDateTimeDeserializer;
import ma.sir.ged.zynerator.util.LocalDateTimeSerializer;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentPartageGroupeDto  extends AuditBaseDto {

    private LocalDateTime dateShare ;

    private DocumentDto document ;
    private GroupeDto groupe ;
    private AccessShareDto accessShare ;



    public DocumentPartageGroupeDto(){
        super();
    }



    @Log
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)

    public LocalDateTime getDateShare(){
        return this.dateShare;
    }
    public void setDateShare(LocalDateTime dateShare){
        this.dateShare = dateShare;
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
    public AccessShareDto getAccessShare(){
        return this.accessShare;
    }

    public void setAccessShare(AccessShareDto accessShare){
        this.accessShare = accessShare;
    }




}
