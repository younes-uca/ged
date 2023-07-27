package  ma.sir.chocho.ws.dto;

import ma.sir.chocho.zynerator.audit.Log;
import ma.sir.chocho.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseTagDto  extends AuditBaseDto {


    private PurchaseDto purchase ;
    private TagDto tag ;



    public PurchaseTagDto(){
        super();
    }




    public PurchaseDto getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseDto purchase){
        this.purchase = purchase;
    }
    public TagDto getTag(){
        return this.tag;
    }

    public void setTag(TagDto tag){
        this.tag = tag;
    }




}
