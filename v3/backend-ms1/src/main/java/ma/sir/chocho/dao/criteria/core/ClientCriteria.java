package  ma.sir.chocho.dao.criteria.core;


import ma.sir.chocho.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ClientCriteria extends  BaseCriteria  {

    private String fullName;
    private String fullNameLike;
    private String email;
    private String emailLike;
    private LocalDateTime dateRegistration;
    private LocalDateTime dateRegistrationFrom;
    private LocalDateTime dateRegistrationTo;
    private String nombreEnfant;
    private String nombreEnfantMin;
    private String nombreEnfantMax;

    private ClientCategoryCriteria clientCategory ;
    private List<ClientCategoryCriteria> clientCategorys ;


    public ClientCriteria(){}

    public String getFullName(){
        return this.fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getFullNameLike(){
        return this.fullNameLike;
    }
    public void setFullNameLike(String fullNameLike){
        this.fullNameLike = fullNameLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public LocalDateTime getDateRegistration(){
        return this.dateRegistration;
    }
    public void setDateRegistration(LocalDateTime dateRegistration){
        this.dateRegistration = dateRegistration;
    }
    public LocalDateTime getDateRegistrationFrom(){
        return this.dateRegistrationFrom;
    }
    public void setDateRegistrationFrom(LocalDateTime dateRegistrationFrom){
        this.dateRegistrationFrom = dateRegistrationFrom;
    }
    public LocalDateTime getDateRegistrationTo(){
        return this.dateRegistrationTo;
    }
    public void setDateRegistrationTo(LocalDateTime dateRegistrationTo){
        this.dateRegistrationTo = dateRegistrationTo;
    }
    public String getNombreEnfant(){
        return this.nombreEnfant;
    }
    public void setNombreEnfant(String nombreEnfant){
        this.nombreEnfant = nombreEnfant;
    }   
    public String getNombreEnfantMin(){
        return this.nombreEnfantMin;
    }
    public void setNombreEnfantMin(String nombreEnfantMin){
        this.nombreEnfantMin = nombreEnfantMin;
    }
    public String getNombreEnfantMax(){
        return this.nombreEnfantMax;
    }
    public void setNombreEnfantMax(String nombreEnfantMax){
        this.nombreEnfantMax = nombreEnfantMax;
    }
      

    public ClientCategoryCriteria getClientCategory(){
        return this.clientCategory;
    }

    public void setClientCategory(ClientCategoryCriteria clientCategory){
        this.clientCategory = clientCategory;
    }
    public List<ClientCategoryCriteria> getClientCategorys(){
        return this.clientCategorys;
    }

    public void setClientCategorys(List<ClientCategoryCriteria> clientCategorys){
        this.clientCategorys = clientCategorys;
    }
}
