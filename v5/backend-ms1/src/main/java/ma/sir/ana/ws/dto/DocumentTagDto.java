package  ma.sir.ana.ws.dto;

import ma.sir.ana.zynerator.audit.Log;
import ma.sir.ana.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentTagDto  extends AuditBaseDto {


    private DocumentDto document ;
    private TagDto tag ;



    public DocumentTagDto(){
        super();
    }




    public DocumentDto getDocument(){
        return this.document;
    }

    public void setDocument(DocumentDto document){
        this.document = document;
    }
    public TagDto getTag(){
        return this.tag;
    }

    public void setTag(TagDto tag){
        this.tag = tag;
    }




}
