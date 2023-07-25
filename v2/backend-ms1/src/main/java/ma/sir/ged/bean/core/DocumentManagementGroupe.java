package ma.sir.ged.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ged.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "document_management_groupe")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="document_management_groupe_seq",sequenceName="document_management_groupe_seq",allocationSize=1, initialValue = 1)
public class DocumentManagementGroupe   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateManagement ;

    private Document document ;
    
    private Groupe groupe ;
    
    private AcessManagement acessManagement ;
    


    public DocumentManagementGroupe(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="document_management_groupe_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Document getDocument(){
        return this.document;
    }
    public void setDocument(Document document){
        this.document = document;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Groupe getGroupe(){
        return this.groupe;
    }
    public void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }
    public LocalDateTime getDateManagement(){
        return this.dateManagement;
    }
    public void setDateManagement(LocalDateTime dateManagement){
        this.dateManagement = dateManagement;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AcessManagement getAcessManagement(){
        return this.acessManagement;
    }
    public void setAcessManagement(AcessManagement acessManagement){
        this.acessManagement = acessManagement;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentManagementGroupe documentManagementGroupe = (DocumentManagementGroupe) o;
        return id != null && id.equals(documentManagementGroupe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

