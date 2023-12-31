package  ma.sir.ana.ws.dto;

import ma.sir.ana.zynerator.audit.Log;
import ma.sir.ana.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentDto  extends AuditBaseDto {

    private String reference  ;
    private String uploadDate ;
    private String dateLastUpdate ;
    private String content  ;
    private BigDecimal size  ;
    private String description  ;
    private Boolean archive  ;
    private Boolean versionne  ;

    private DocumentTypeDto documentType ;
    private DocumentStateDto documentState ;
    private DocumentCategorieDto documentCategorie ;
    private UtilisateurDto utilisateur ;
    private EntiteAdministrativeDto entiteAdministrative ;

    private List<DocumentFieldDto> documentFields ;
    private List<DocumentPartageGroupeDto> documentPartageGroupes ;
    private List<DocumentPartageUtilisateurDto> documentPartageUtilisateurs ;
    private List<DocumentManagementGroupeDto> documentManagementGroupes ;
    private List<DocumentManagementUtilisateurDto> documentManagementUtilisateurs ;
    private List<DocumentAcessShareDto> documentAcessShares ;
    private List<DocumentTagDto> documentTags ;


    public DocumentDto(){
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getUploadDate(){
        return this.uploadDate;
    }
    public void setUploadDate(String uploadDate){
        this.uploadDate = uploadDate;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateLastUpdate(){
        return this.dateLastUpdate;
    }
    public void setDateLastUpdate(String dateLastUpdate){
        this.dateLastUpdate = dateLastUpdate;
    }

    @Log
    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content = content;
    }

    @Log
    public BigDecimal getSize(){
        return this.size;
    }
    public void setSize(BigDecimal size){
        this.size = size;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public Boolean getArchive(){
        return this.archive;
    }
    public void setArchive(Boolean archive){
        this.archive = archive;
    }

    @Log
    public Boolean getVersionne(){
        return this.versionne;
    }
    public void setVersionne(Boolean versionne){
        this.versionne = versionne;
    }


    public DocumentTypeDto getDocumentType(){
        return this.documentType;
    }

    public void setDocumentType(DocumentTypeDto documentType){
        this.documentType = documentType;
    }
    public DocumentStateDto getDocumentState(){
        return this.documentState;
    }

    public void setDocumentState(DocumentStateDto documentState){
        this.documentState = documentState;
    }
    public DocumentCategorieDto getDocumentCategorie(){
        return this.documentCategorie;
    }

    public void setDocumentCategorie(DocumentCategorieDto documentCategorie){
        this.documentCategorie = documentCategorie;
    }
    public UtilisateurDto getUtilisateur(){
        return this.utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur){
        this.utilisateur = utilisateur;
    }
    public EntiteAdministrativeDto getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeDto entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }



    public List<DocumentFieldDto> getDocumentFields(){
        return this.documentFields;
    }

    public void setDocumentFields(List<DocumentFieldDto> documentFields){
        this.documentFields = documentFields;
    }
    public List<DocumentPartageGroupeDto> getDocumentPartageGroupes(){
        return this.documentPartageGroupes;
    }

    public void setDocumentPartageGroupes(List<DocumentPartageGroupeDto> documentPartageGroupes){
        this.documentPartageGroupes = documentPartageGroupes;
    }
    public List<DocumentPartageUtilisateurDto> getDocumentPartageUtilisateurs(){
        return this.documentPartageUtilisateurs;
    }

    public void setDocumentPartageUtilisateurs(List<DocumentPartageUtilisateurDto> documentPartageUtilisateurs){
        this.documentPartageUtilisateurs = documentPartageUtilisateurs;
    }
    public List<DocumentManagementGroupeDto> getDocumentManagementGroupes(){
        return this.documentManagementGroupes;
    }

    public void setDocumentManagementGroupes(List<DocumentManagementGroupeDto> documentManagementGroupes){
        this.documentManagementGroupes = documentManagementGroupes;
    }
    public List<DocumentManagementUtilisateurDto> getDocumentManagementUtilisateurs(){
        return this.documentManagementUtilisateurs;
    }

    public void setDocumentManagementUtilisateurs(List<DocumentManagementUtilisateurDto> documentManagementUtilisateurs){
        this.documentManagementUtilisateurs = documentManagementUtilisateurs;
    }
    public List<DocumentAcessShareDto> getDocumentAcessShares(){
        return this.documentAcessShares;
    }

    public void setDocumentAcessShares(List<DocumentAcessShareDto> documentAcessShares){
        this.documentAcessShares = documentAcessShares;
    }
    public List<DocumentTagDto> getDocumentTags(){
        return this.documentTags;
    }

    public void setDocumentTags(List<DocumentTagDto> documentTags){
        this.documentTags = documentTags;
    }

}
