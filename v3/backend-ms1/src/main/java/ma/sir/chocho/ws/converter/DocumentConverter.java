package  ma.sir.chocho.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.chocho.zynerator.util.ListUtil;


import ma.sir.chocho.zynerator.util.StringUtil;
import ma.sir.chocho.zynerator.converter.AbstractConverter;
import ma.sir.chocho.zynerator.util.DateUtil;
import ma.sir.chocho.bean.history.DocumentHistory;
import ma.sir.chocho.bean.core.Document;
import ma.sir.chocho.ws.dto.DocumentDto;

@Component
public class DocumentConverter extends AbstractConverter<Document, DocumentDto, DocumentHistory> {

    @Autowired
    private DocumentManagementGroupeConverter documentManagementGroupeConverter ;
    @Autowired
    private DocumentAcessShareConverter documentAcessShareConverter ;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private DocumentTypeConverter documentTypeConverter ;
    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    @Autowired
    private DocumentTagConverter documentTagConverter ;
    @Autowired
    private AcessManagementConverter acessManagementConverter ;
    @Autowired
    private DocumentPartageUtilisateurConverter documentPartageUtilisateurConverter ;
    @Autowired
    private DocumentManagementUtilisateurConverter documentManagementUtilisateurConverter ;
    @Autowired
    private GroupeConverter groupeConverter ;
    @Autowired
    private AcessShareConverter acessShareConverter ;
    @Autowired
    private DocumentPartageGroupeConverter documentPartageGroupeConverter ;
    @Autowired
    private TagConverter tagConverter ;
    private boolean documentType;
    private boolean utilisateur;
    private boolean entiteAdministrative;
    private boolean documentPartageGroupes;
    private boolean documentPartageUtilisateurs;
    private boolean documentManagementGroupes;
    private boolean documentManagementUtilisateurs;
    private boolean documentAcessShares;
    private boolean documentTags;

    public  DocumentConverter(){
        super(Document.class, DocumentDto.class, DocumentHistory.class);
        init(true);
    }

    @Override
    public Document toItem(DocumentDto dto) {
        if (dto == null) {
            return null;
        } else {
        Document item = new Document();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getUploadDate()))
                item.setUploadDate(DateUtil.stringEnToDate(dto.getUploadDate()));
            if(StringUtil.isNotEmpty(dto.getDateLastUpdate()))
                item.setDateLastUpdate(DateUtil.stringEnToDate(dto.getDateLastUpdate()));
            if(StringUtil.isNotEmpty(dto.getContent()))
                item.setContent(dto.getContent());
            if(StringUtil.isNotEmpty(dto.getSize()))
                item.setSize(dto.getSize());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getArchive() != null)
                item.setArchive(dto.getArchive());
            if(dto.getVersionne() != null)
                item.setVersionne(dto.getVersionne());
            if(this.documentType && dto.getDocumentType()!=null &&  dto.getDocumentType().getId() != null)
                item.setDocumentType(documentTypeConverter.toItem(dto.getDocumentType())) ;

            if(this.utilisateur && dto.getUtilisateur()!=null &&  dto.getUtilisateur().getId() != null)
                item.setUtilisateur(utilisateurConverter.toItem(dto.getUtilisateur())) ;

            if(this.entiteAdministrative && dto.getEntiteAdministrative()!=null &&  dto.getEntiteAdministrative().getId() != null)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrative())) ;


            if(this.documentPartageGroupes && ListUtil.isNotEmpty(dto.getDocumentPartageGroupes()))
                item.setDocumentPartageGroupes(documentPartageGroupeConverter.toItem(dto.getDocumentPartageGroupes()));
            if(this.documentPartageUtilisateurs && ListUtil.isNotEmpty(dto.getDocumentPartageUtilisateurs()))
                item.setDocumentPartageUtilisateurs(documentPartageUtilisateurConverter.toItem(dto.getDocumentPartageUtilisateurs()));
            if(this.documentManagementGroupes && ListUtil.isNotEmpty(dto.getDocumentManagementGroupes()))
                item.setDocumentManagementGroupes(documentManagementGroupeConverter.toItem(dto.getDocumentManagementGroupes()));
            if(this.documentManagementUtilisateurs && ListUtil.isNotEmpty(dto.getDocumentManagementUtilisateurs()))
                item.setDocumentManagementUtilisateurs(documentManagementUtilisateurConverter.toItem(dto.getDocumentManagementUtilisateurs()));
            if(this.documentAcessShares && ListUtil.isNotEmpty(dto.getDocumentAcessShares()))
                item.setDocumentAcessShares(documentAcessShareConverter.toItem(dto.getDocumentAcessShares()));
            if(this.documentTags && ListUtil.isNotEmpty(dto.getDocumentTags()))
                item.setDocumentTags(documentTagConverter.toItem(dto.getDocumentTags()));

        return item;
        }
    }

    @Override
    public DocumentDto toDto(Document item) {
        if (item == null) {
            return null;
        } else {
            DocumentDto dto = new DocumentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getUploadDate()!=null)
                dto.setUploadDate(DateUtil.dateTimeToString(item.getUploadDate()));
            if(item.getDateLastUpdate()!=null)
                dto.setDateLastUpdate(DateUtil.dateTimeToString(item.getDateLastUpdate()));
            if(StringUtil.isNotEmpty(item.getContent()))
                dto.setContent(item.getContent());
            if(StringUtil.isNotEmpty(item.getSize()))
                dto.setSize(item.getSize());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
                dto.setArchive(item.getArchive());
                dto.setVersionne(item.getVersionne());
        if(this.documentType && item.getDocumentType()!=null) {
            dto.setDocumentType(documentTypeConverter.toDto(item.getDocumentType())) ;
        }
        if(this.utilisateur && item.getUtilisateur()!=null) {
            dto.setUtilisateur(utilisateurConverter.toDto(item.getUtilisateur())) ;
        }
        if(this.entiteAdministrative && item.getEntiteAdministrative()!=null) {
            dto.setEntiteAdministrative(entiteAdministrativeConverter.toDto(item.getEntiteAdministrative())) ;
        }
        if(this.documentPartageGroupes && ListUtil.isNotEmpty(item.getDocumentPartageGroupes())){
            documentPartageGroupeConverter.init(true);
            documentPartageGroupeConverter.setDocument(false);
            dto.setDocumentPartageGroupes(documentPartageGroupeConverter.toDto(item.getDocumentPartageGroupes()));
            documentPartageGroupeConverter.setDocument(true);

        }
        if(this.documentPartageUtilisateurs && ListUtil.isNotEmpty(item.getDocumentPartageUtilisateurs())){
            documentPartageUtilisateurConverter.init(true);
            documentPartageUtilisateurConverter.setDocument(false);
            dto.setDocumentPartageUtilisateurs(documentPartageUtilisateurConverter.toDto(item.getDocumentPartageUtilisateurs()));
            documentPartageUtilisateurConverter.setDocument(true);

        }
        if(this.documentManagementGroupes && ListUtil.isNotEmpty(item.getDocumentManagementGroupes())){
            documentManagementGroupeConverter.init(true);
            documentManagementGroupeConverter.setDocument(false);
            dto.setDocumentManagementGroupes(documentManagementGroupeConverter.toDto(item.getDocumentManagementGroupes()));
            documentManagementGroupeConverter.setDocument(true);

        }
        if(this.documentManagementUtilisateurs && ListUtil.isNotEmpty(item.getDocumentManagementUtilisateurs())){
            documentManagementUtilisateurConverter.init(true);
            documentManagementUtilisateurConverter.setDocument(false);
            dto.setDocumentManagementUtilisateurs(documentManagementUtilisateurConverter.toDto(item.getDocumentManagementUtilisateurs()));
            documentManagementUtilisateurConverter.setDocument(true);

        }
        if(this.documentAcessShares && ListUtil.isNotEmpty(item.getDocumentAcessShares())){
            documentAcessShareConverter.init(true);
            documentAcessShareConverter.setDocument(false);
            dto.setDocumentAcessShares(documentAcessShareConverter.toDto(item.getDocumentAcessShares()));
            documentAcessShareConverter.setDocument(true);

        }
        if(this.documentTags && ListUtil.isNotEmpty(item.getDocumentTags())){
            documentTagConverter.init(true);
            documentTagConverter.setDocument(false);
            dto.setDocumentTags(documentTagConverter.toDto(item.getDocumentTags()));
            documentTagConverter.setDocument(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.documentPartageGroupes = value;
        this.documentPartageUtilisateurs = value;
        this.documentManagementGroupes = value;
        this.documentManagementUtilisateurs = value;
        this.documentAcessShares = value;
        this.documentTags = value;
    }

    public void initObject(boolean value) {
        this.documentType = value;
        this.utilisateur = value;
        this.entiteAdministrative = value;
    }


    public DocumentManagementGroupeConverter getDocumentManagementGroupeConverter(){
        return this.documentManagementGroupeConverter;
    }
    public void setDocumentManagementGroupeConverter(DocumentManagementGroupeConverter documentManagementGroupeConverter ){
        this.documentManagementGroupeConverter = documentManagementGroupeConverter;
    }
    public DocumentAcessShareConverter getDocumentAcessShareConverter(){
        return this.documentAcessShareConverter;
    }
    public void setDocumentAcessShareConverter(DocumentAcessShareConverter documentAcessShareConverter ){
        this.documentAcessShareConverter = documentAcessShareConverter;
    }
    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public DocumentTypeConverter getDocumentTypeConverter(){
        return this.documentTypeConverter;
    }
    public void setDocumentTypeConverter(DocumentTypeConverter documentTypeConverter ){
        this.documentTypeConverter = documentTypeConverter;
    }
    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public DocumentTagConverter getDocumentTagConverter(){
        return this.documentTagConverter;
    }
    public void setDocumentTagConverter(DocumentTagConverter documentTagConverter ){
        this.documentTagConverter = documentTagConverter;
    }
    public AcessManagementConverter getAcessManagementConverter(){
        return this.acessManagementConverter;
    }
    public void setAcessManagementConverter(AcessManagementConverter acessManagementConverter ){
        this.acessManagementConverter = acessManagementConverter;
    }
    public DocumentPartageUtilisateurConverter getDocumentPartageUtilisateurConverter(){
        return this.documentPartageUtilisateurConverter;
    }
    public void setDocumentPartageUtilisateurConverter(DocumentPartageUtilisateurConverter documentPartageUtilisateurConverter ){
        this.documentPartageUtilisateurConverter = documentPartageUtilisateurConverter;
    }
    public DocumentManagementUtilisateurConverter getDocumentManagementUtilisateurConverter(){
        return this.documentManagementUtilisateurConverter;
    }
    public void setDocumentManagementUtilisateurConverter(DocumentManagementUtilisateurConverter documentManagementUtilisateurConverter ){
        this.documentManagementUtilisateurConverter = documentManagementUtilisateurConverter;
    }
    public GroupeConverter getGroupeConverter(){
        return this.groupeConverter;
    }
    public void setGroupeConverter(GroupeConverter groupeConverter ){
        this.groupeConverter = groupeConverter;
    }
    public AcessShareConverter getAcessShareConverter(){
        return this.acessShareConverter;
    }
    public void setAcessShareConverter(AcessShareConverter acessShareConverter ){
        this.acessShareConverter = acessShareConverter;
    }
    public DocumentPartageGroupeConverter getDocumentPartageGroupeConverter(){
        return this.documentPartageGroupeConverter;
    }
    public void setDocumentPartageGroupeConverter(DocumentPartageGroupeConverter documentPartageGroupeConverter ){
        this.documentPartageGroupeConverter = documentPartageGroupeConverter;
    }
    public TagConverter getTagConverter(){
        return this.tagConverter;
    }
    public void setTagConverter(TagConverter tagConverter ){
        this.tagConverter = tagConverter;
    }
    public boolean  isDocumentType(){
        return this.documentType;
    }
    public void  setDocumentType(boolean documentType){
        this.documentType = documentType;
    }
    public boolean  isUtilisateur(){
        return this.utilisateur;
    }
    public void  setUtilisateur(boolean utilisateur){
        this.utilisateur = utilisateur;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    public boolean  isDocumentPartageGroupes(){
        return this.documentPartageGroupes ;
    }
    public void  setDocumentPartageGroupes(boolean documentPartageGroupes ){
        this.documentPartageGroupes  = documentPartageGroupes ;
    }
    public boolean  isDocumentPartageUtilisateurs(){
        return this.documentPartageUtilisateurs ;
    }
    public void  setDocumentPartageUtilisateurs(boolean documentPartageUtilisateurs ){
        this.documentPartageUtilisateurs  = documentPartageUtilisateurs ;
    }
    public boolean  isDocumentManagementGroupes(){
        return this.documentManagementGroupes ;
    }
    public void  setDocumentManagementGroupes(boolean documentManagementGroupes ){
        this.documentManagementGroupes  = documentManagementGroupes ;
    }
    public boolean  isDocumentManagementUtilisateurs(){
        return this.documentManagementUtilisateurs ;
    }
    public void  setDocumentManagementUtilisateurs(boolean documentManagementUtilisateurs ){
        this.documentManagementUtilisateurs  = documentManagementUtilisateurs ;
    }
    public boolean  isDocumentAcessShares(){
        return this.documentAcessShares ;
    }
    public void  setDocumentAcessShares(boolean documentAcessShares ){
        this.documentAcessShares  = documentAcessShares ;
    }
    public boolean  isDocumentTags(){
        return this.documentTags ;
    }
    public void  setDocumentTags(boolean documentTags ){
        this.documentTags  = documentTags ;
    }
}
