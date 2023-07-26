package  ma.sir.chocho.ws.dto;

import ma.sir.chocho.zynerator.audit.Log;
import ma.sir.chocho.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientCategoryDto  extends AuditBaseDto {

    private String reference  ;
    private String code  ;
    private Integer socialIndex  = 0 ;




    public ClientCategoryDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public Integer getSocialIndex(){
        return this.socialIndex;
    }
    public void setSocialIndex(Integer socialIndex){
        this.socialIndex = socialIndex;
    }






}
