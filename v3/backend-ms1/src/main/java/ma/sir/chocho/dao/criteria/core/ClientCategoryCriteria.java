package  ma.sir.chocho.dao.criteria.core;


import ma.sir.chocho.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ClientCategoryCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String code;
    private String codeLike;
    private String socialIndex;
    private String socialIndexMin;
    private String socialIndexMax;



    public ClientCategoryCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getSocialIndex(){
        return this.socialIndex;
    }
    public void setSocialIndex(String socialIndex){
        this.socialIndex = socialIndex;
    }   
    public String getSocialIndexMin(){
        return this.socialIndexMin;
    }
    public void setSocialIndexMin(String socialIndexMin){
        this.socialIndexMin = socialIndexMin;
    }
    public String getSocialIndexMax(){
        return this.socialIndexMax;
    }
    public void setSocialIndexMax(String socialIndexMax){
        this.socialIndexMax = socialIndexMax;
    }
      

}
