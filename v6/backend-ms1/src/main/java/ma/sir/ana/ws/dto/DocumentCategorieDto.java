package  ma.sir.ana.ws.dto;

import ma.sir.ana.zynerator.audit.Log;
import ma.sir.ana.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentCategorieDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;


    private List<DocumentCategorieFieldDto> documentCategorieFields ;


    public DocumentCategorieDto(){
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





    public List<DocumentCategorieFieldDto> getDocumentCategorieFields(){
        return this.documentCategorieFields;
    }

    public void setDocumentCategorieFields(List<DocumentCategorieFieldDto> documentCategorieFields){
        this.documentCategorieFields = documentCategorieFields;
    }

}
