package  ma.sir.ged.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ged.zynerator.util.ListUtil;

import ma.sir.ged.bean.core.DocumentCategorie;

import ma.sir.ged.zynerator.util.StringUtil;
import ma.sir.ged.zynerator.converter.AbstractConverter;
import ma.sir.ged.zynerator.util.DateUtil;
import ma.sir.ged.bean.history.DocumentHistory;
import ma.sir.ged.bean.core.Document;
import ma.sir.ged.ws.dto.DocumentDto;

@Component
public class DocumentConverter extends AbstractConverter<Document, DocumentDto, DocumentHistory> {

    @Autowired
    private DocumentFieldConverter documentFieldConverter ;
    @Autowired
    private DocumentFieldStateConverter documentFieldStateConverter ;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private DocumentPartageGroupeConverter documentPartageGroupeConverter ;
    @Autowired
    private DocumentPartageUtilisateurConverter documentPartageUtilisateurConverter ;
    @Autowired
    private DocumentStateConverter documentStateConverter ;
    @Autowired
    private GroupeConverter groupeConverter ;
    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    @Autowired
    private AccessShareConverter accessShareConverter ;
    @Autowired
    private FieldConverter fieldConverter ;
    @Autowired
    private DocumentCategorieConverter documentCategorieConverter ;
    @Autowired
    private DocumentTypeConverter documentTypeConverter ;
    private boolean documentType;
    private boolean documentState;
    private boolean documentCategorie;
    private boolean proprietaire;
    private boolean entiteAdministrative;
    private boolean entiteAdministrativeProprietaire;
    private boolean documentFields;
    private boolean documentPartageGroupes;
    private boolean documentPartageUtilisateurs;

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
            if(dto.getFolder() != null)
                item.setFolder(dto.getFolder());
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

            if(this.documentState && dto.getDocumentState()!=null &&  dto.getDocumentState().getId() != null)
                item.setDocumentState(documentStateConverter.toItem(dto.getDocumentState())) ;

            if(dto.getDocumentCategorie() != null && dto.getDocumentCategorie().getId() != null){
                item.setDocumentCategorie(new DocumentCategorie());
                item.getDocumentCategorie().setId(dto.getDocumentCategorie().getId());
            }

            if(this.proprietaire && dto.getProprietaire()!=null &&  dto.getProprietaire().getId() != null)
                item.setProprietaire(utilisateurConverter.toItem(dto.getProprietaire())) ;

            if(this.entiteAdministrative && dto.getEntiteAdministrative()!=null &&  dto.getEntiteAdministrative().getId() != null)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrative())) ;

            if(this.entiteAdministrativeProprietaire && dto.getEntiteAdministrativeProprietaire()!=null &&  dto.getEntiteAdministrativeProprietaire().getId() != null)
                item.setEntiteAdministrativeProprietaire(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrativeProprietaire())) ;


            if(this.documentFields && ListUtil.isNotEmpty(dto.getDocumentFields()))
                item.setDocumentFields(documentFieldConverter.toItem(dto.getDocumentFields()));
            if(this.documentPartageGroupes && ListUtil.isNotEmpty(dto.getDocumentPartageGroupes()))
                item.setDocumentPartageGroupes(documentPartageGroupeConverter.toItem(dto.getDocumentPartageGroupes()));
            if(this.documentPartageUtilisateurs && ListUtil.isNotEmpty(dto.getDocumentPartageUtilisateurs()))
                item.setDocumentPartageUtilisateurs(documentPartageUtilisateurConverter.toItem(dto.getDocumentPartageUtilisateurs()));

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
                dto.setFolder(item.getFolder());
            if(StringUtil.isNotEmpty(item.getSize()))
                dto.setSize(item.getSize());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
                dto.setArchive(item.getArchive());
                dto.setVersionne(item.getVersionne());
        if(this.documentType && item.getDocumentType()!=null) {
            dto.setDocumentType(documentTypeConverter.toDto(item.getDocumentType())) ;
        }
        if(this.documentState && item.getDocumentState()!=null) {
            dto.setDocumentState(documentStateConverter.toDto(item.getDocumentState())) ;
        }
        if(this.documentCategorie && item.getDocumentCategorie()!=null) {
            dto.setDocumentCategorie(documentCategorieConverter.toDto(item.getDocumentCategorie())) ;
        }
        if(this.proprietaire && item.getProprietaire()!=null) {
            dto.setProprietaire(utilisateurConverter.toDto(item.getProprietaire())) ;
        }
        if(this.entiteAdministrative && item.getEntiteAdministrative()!=null) {
            dto.setEntiteAdministrative(entiteAdministrativeConverter.toDto(item.getEntiteAdministrative())) ;
        }
        if(this.entiteAdministrativeProprietaire && item.getEntiteAdministrativeProprietaire()!=null) {
            dto.setEntiteAdministrativeProprietaire(entiteAdministrativeConverter.toDto(item.getEntiteAdministrativeProprietaire())) ;
        }
        if(this.documentFields && ListUtil.isNotEmpty(item.getDocumentFields())){
            documentFieldConverter.init(true);
            documentFieldConverter.setDocument(false);
            dto.setDocumentFields(documentFieldConverter.toDto(item.getDocumentFields()));
            documentFieldConverter.setDocument(true);

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


        return dto;
        }
    }

    public void initList(boolean value) {
        this.documentFields = value;
        this.documentPartageGroupes = value;
        this.documentPartageUtilisateurs = value;
    }

    public void initObject(boolean value) {
        this.documentType = value;
        this.documentState = value;
        this.documentCategorie = value;
        this.proprietaire = value;
        this.entiteAdministrative = value;
        this.entiteAdministrativeProprietaire = value;
    }


    public DocumentFieldConverter getDocumentFieldConverter(){
        return this.documentFieldConverter;
    }
    public void setDocumentFieldConverter(DocumentFieldConverter documentFieldConverter ){
        this.documentFieldConverter = documentFieldConverter;
    }
    public DocumentFieldStateConverter getDocumentFieldStateConverter(){
        return this.documentFieldStateConverter;
    }
    public void setDocumentFieldStateConverter(DocumentFieldStateConverter documentFieldStateConverter ){
        this.documentFieldStateConverter = documentFieldStateConverter;
    }
    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public DocumentPartageGroupeConverter getDocumentPartageGroupeConverter(){
        return this.documentPartageGroupeConverter;
    }
    public void setDocumentPartageGroupeConverter(DocumentPartageGroupeConverter documentPartageGroupeConverter ){
        this.documentPartageGroupeConverter = documentPartageGroupeConverter;
    }
    public DocumentPartageUtilisateurConverter getDocumentPartageUtilisateurConverter(){
        return this.documentPartageUtilisateurConverter;
    }
    public void setDocumentPartageUtilisateurConverter(DocumentPartageUtilisateurConverter documentPartageUtilisateurConverter ){
        this.documentPartageUtilisateurConverter = documentPartageUtilisateurConverter;
    }
    public DocumentStateConverter getDocumentStateConverter(){
        return this.documentStateConverter;
    }
    public void setDocumentStateConverter(DocumentStateConverter documentStateConverter ){
        this.documentStateConverter = documentStateConverter;
    }
    public GroupeConverter getGroupeConverter(){
        return this.groupeConverter;
    }
    public void setGroupeConverter(GroupeConverter groupeConverter ){
        this.groupeConverter = groupeConverter;
    }
    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public AccessShareConverter getAccessShareConverter(){
        return this.accessShareConverter;
    }
    public void setAccessShareConverter(AccessShareConverter accessShareConverter ){
        this.accessShareConverter = accessShareConverter;
    }
    public FieldConverter getFieldConverter(){
        return this.fieldConverter;
    }
    public void setFieldConverter(FieldConverter fieldConverter ){
        this.fieldConverter = fieldConverter;
    }
    public DocumentCategorieConverter getDocumentCategorieConverter(){
        return this.documentCategorieConverter;
    }
    public void setDocumentCategorieConverter(DocumentCategorieConverter documentCategorieConverter ){
        this.documentCategorieConverter = documentCategorieConverter;
    }
    public DocumentTypeConverter getDocumentTypeConverter(){
        return this.documentTypeConverter;
    }
    public void setDocumentTypeConverter(DocumentTypeConverter documentTypeConverter ){
        this.documentTypeConverter = documentTypeConverter;
    }
    public boolean  isDocumentType(){
        return this.documentType;
    }
    public void  setDocumentType(boolean documentType){
        this.documentType = documentType;
    }
    public boolean  isDocumentState(){
        return this.documentState;
    }
    public void  setDocumentState(boolean documentState){
        this.documentState = documentState;
    }
    public boolean  isDocumentCategorie(){
        return this.documentCategorie;
    }
    public void  setDocumentCategorie(boolean documentCategorie){
        this.documentCategorie = documentCategorie;
    }
    public boolean  isProprietaire(){
        return this.proprietaire;
    }
    public void  setProprietaire(boolean proprietaire){
        this.proprietaire = proprietaire;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    public boolean  isEntiteAdministrativeProprietaire(){
        return this.entiteAdministrativeProprietaire;
    }
    public void  setEntiteAdministrativeProprietaire(boolean entiteAdministrativeProprietaire){
        this.entiteAdministrativeProprietaire = entiteAdministrativeProprietaire;
    }
    public boolean  isDocumentFields(){
        return this.documentFields ;
    }
    public void  setDocumentFields(boolean documentFields ){
        this.documentFields  = documentFields ;
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
}
