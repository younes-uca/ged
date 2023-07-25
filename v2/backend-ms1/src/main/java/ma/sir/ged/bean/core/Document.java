package ma.sir.ged.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ged.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "document")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="document_seq",sequenceName="document_seq",allocationSize=1, initialValue = 1)
public class Document   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime uploadDate ;
    private LocalDateTime dateLastUpdate ;
    @Column(length = 500)
    private String content;
    private BigDecimal size = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;
    @Column(columnDefinition = "boolean default false")
    private Boolean archive = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean versionne = false;

    private DocumentType documentType ;
    
    private Utilisateur utilisateur ;
    
    private EntiteAdministrative entiteAdministrative ;
    

    private List<DocumentPartageGroupe> documentPartageGroupes ;
    private List<DocumentPartageUtilisateur> documentPartageUtilisateurs ;
    private List<DocumentManagementGroupe> documentManagementGroupes ;
    private List<DocumentManagementUtilisateur> documentManagementUtilisateurs ;
    private List<DocumentAcessShare> documentAcessShares ;
    private List<DocumentTag> documentTags ;

    public Document(){
        super();
    }

    public Document(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="document_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getUploadDate(){
        return this.uploadDate;
    }
    public void setUploadDate(LocalDateTime uploadDate){
        this.uploadDate = uploadDate;
    }
    public LocalDateTime getDateLastUpdate(){
        return this.dateLastUpdate;
    }
    public void setDateLastUpdate(LocalDateTime dateLastUpdate){
        this.dateLastUpdate = dateLastUpdate;
    }
    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public BigDecimal getSize(){
        return this.size;
    }
    public void setSize(BigDecimal size){
        this.size = size;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public DocumentType getDocumentType(){
        return this.documentType;
    }
    public void setDocumentType(DocumentType documentType){
        this.documentType = documentType;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Utilisateur getUtilisateur(){
        return this.utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur){
        this.utilisateur = utilisateur;
    }
    public Boolean  getArchive(){
        return this.archive;
    }
    public void setArchive(Boolean archive){
        this.archive = archive;
    }
    public Boolean  getVersionne(){
        return this.versionne;
    }
    public void setVersionne(Boolean versionne){
        this.versionne = versionne;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EntiteAdministrative getEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    @OneToMany(mappedBy = "document")
    public List<DocumentPartageGroupe> getDocumentPartageGroupes(){
        return this.documentPartageGroupes;
    }
    public void setDocumentPartageGroupes(List<DocumentPartageGroupe> documentPartageGroupes){
        this.documentPartageGroupes = documentPartageGroupes;
    }
    @OneToMany(mappedBy = "document")
    public List<DocumentPartageUtilisateur> getDocumentPartageUtilisateurs(){
        return this.documentPartageUtilisateurs;
    }
    public void setDocumentPartageUtilisateurs(List<DocumentPartageUtilisateur> documentPartageUtilisateurs){
        this.documentPartageUtilisateurs = documentPartageUtilisateurs;
    }
    @OneToMany(mappedBy = "document")
    public List<DocumentManagementGroupe> getDocumentManagementGroupes(){
        return this.documentManagementGroupes;
    }
    public void setDocumentManagementGroupes(List<DocumentManagementGroupe> documentManagementGroupes){
        this.documentManagementGroupes = documentManagementGroupes;
    }
    @OneToMany(mappedBy = "document")
    public List<DocumentManagementUtilisateur> getDocumentManagementUtilisateurs(){
        return this.documentManagementUtilisateurs;
    }
    public void setDocumentManagementUtilisateurs(List<DocumentManagementUtilisateur> documentManagementUtilisateurs){
        this.documentManagementUtilisateurs = documentManagementUtilisateurs;
    }
    @OneToMany(mappedBy = "document")
    public List<DocumentAcessShare> getDocumentAcessShares(){
        return this.documentAcessShares;
    }
    public void setDocumentAcessShares(List<DocumentAcessShare> documentAcessShares){
        this.documentAcessShares = documentAcessShares;
    }
    @OneToMany(mappedBy = "document")
    public List<DocumentTag> getDocumentTags(){
        return this.documentTags;
    }
    public void setDocumentTags(List<DocumentTag> documentTags){
        this.documentTags = documentTags;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id != null && id.equals(document.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

