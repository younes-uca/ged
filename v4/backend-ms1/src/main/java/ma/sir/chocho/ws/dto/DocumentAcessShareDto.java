package  ma.sir.chocho.ws.dto;

import ma.sir.chocho.zynerator.audit.Log;
import ma.sir.chocho.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentAcessShareDto  extends AuditBaseDto {


    private DocumentDto document ;
    private AcessShareDto acessShare ;



    public DocumentAcessShareDto(){
        super();
    }




    public DocumentDto getDocument(){
        return this.document;
    }

    public void setDocument(DocumentDto document){
        this.document = document;
    }
    public AcessShareDto getAcessShare(){
        return this.acessShare;
    }

    public void setAcessShare(AcessShareDto acessShare){
        this.acessShare = acessShare;
    }




}
