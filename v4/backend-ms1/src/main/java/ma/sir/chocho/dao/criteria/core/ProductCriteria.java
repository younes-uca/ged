package  ma.sir.chocho.dao.criteria.core;


import ma.sir.chocho.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProductCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String reference;
    private String referenceLike;
    private String purchaseCost;
    private String purchaseCostMin;
    private String purchaseCostMax;



    public ProductCriteria(){}

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

    public String getPurchaseCost(){
        return this.purchaseCost;
    }
    public void setPurchaseCost(String purchaseCost){
        this.purchaseCost = purchaseCost;
    }   
    public String getPurchaseCostMin(){
        return this.purchaseCostMin;
    }
    public void setPurchaseCostMin(String purchaseCostMin){
        this.purchaseCostMin = purchaseCostMin;
    }
    public String getPurchaseCostMax(){
        return this.purchaseCostMax;
    }
    public void setPurchaseCostMax(String purchaseCostMax){
        this.purchaseCostMax = purchaseCostMax;
    }
      

}
