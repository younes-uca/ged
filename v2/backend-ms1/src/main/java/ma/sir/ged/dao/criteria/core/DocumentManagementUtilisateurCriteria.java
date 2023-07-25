package  ma.sir.ged.dao.criteria.core;


import ma.sir.ged.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DocumentManagementUtilisateurCriteria extends  BaseCriteria  {

    private LocalDateTime dateManagement;
    private LocalDateTime dateManagementFrom;
    private LocalDateTime dateManagementTo;

    private DocumentCriteria document ;
    private List<DocumentCriteria> documents ;
    private UtilisateurCriteria utilisateur ;
    private List<UtilisateurCriteria> utilisateurs ;
    private AcessManagementCriteria acessManagement ;
    private List<AcessManagementCriteria> acessManagements ;


    public DocumentManagementUtilisateurCriteria(){}

    public LocalDateTime getDateManagement(){
        return this.dateManagement;
    }
    public void setDateManagement(LocalDateTime dateManagement){
        this.dateManagement = dateManagement;
    }
    public LocalDateTime getDateManagementFrom(){
        return this.dateManagementFrom;
    }
    public void setDateManagementFrom(LocalDateTime dateManagementFrom){
        this.dateManagementFrom = dateManagementFrom;
    }
    public LocalDateTime getDateManagementTo(){
        return this.dateManagementTo;
    }
    public void setDateManagementTo(LocalDateTime dateManagementTo){
        this.dateManagementTo = dateManagementTo;
    }

    public DocumentCriteria getDocument(){
        return this.document;
    }

    public void setDocument(DocumentCriteria document){
        this.document = document;
    }
    public List<DocumentCriteria> getDocuments(){
        return this.documents;
    }

    public void setDocuments(List<DocumentCriteria> documents){
        this.documents = documents;
    }
    public UtilisateurCriteria getUtilisateur(){
        return this.utilisateur;
    }

    public void setUtilisateur(UtilisateurCriteria utilisateur){
        this.utilisateur = utilisateur;
    }
    public List<UtilisateurCriteria> getUtilisateurs(){
        return this.utilisateurs;
    }

    public void setUtilisateurs(List<UtilisateurCriteria> utilisateurs){
        this.utilisateurs = utilisateurs;
    }
    public AcessManagementCriteria getAcessManagement(){
        return this.acessManagement;
    }

    public void setAcessManagement(AcessManagementCriteria acessManagement){
        this.acessManagement = acessManagement;
    }
    public List<AcessManagementCriteria> getAcessManagements(){
        return this.acessManagements;
    }

    public void setAcessManagements(List<AcessManagementCriteria> acessManagements){
        this.acessManagements = acessManagements;
    }
}
