package  ma.sir.ged.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ged.bean.core.Document;

import ma.sir.ged.zynerator.util.StringUtil;
import ma.sir.ged.zynerator.converter.AbstractConverter;
import ma.sir.ged.zynerator.util.DateUtil;
import ma.sir.ged.bean.history.DocumentManagementUtilisateurHistory;
import ma.sir.ged.bean.core.DocumentManagementUtilisateur;
import ma.sir.ged.ws.dto.DocumentManagementUtilisateurDto;

@Component
public class DocumentManagementUtilisateurConverter extends AbstractConverter<DocumentManagementUtilisateur, DocumentManagementUtilisateurDto, DocumentManagementUtilisateurHistory> {

    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    @Autowired
    private DocumentConverter documentConverter ;
    @Autowired
    private AcessManagementConverter acessManagementConverter ;
    private boolean document;
    private boolean utilisateur;
    private boolean acessManagement;

    public  DocumentManagementUtilisateurConverter(){
        super(DocumentManagementUtilisateur.class, DocumentManagementUtilisateurDto.class, DocumentManagementUtilisateurHistory.class);
    }

    @Override
    public DocumentManagementUtilisateur toItem(DocumentManagementUtilisateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        DocumentManagementUtilisateur item = new DocumentManagementUtilisateur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateManagement()))
                item.setDateManagement(DateUtil.stringEnToDate(dto.getDateManagement()));
            if(dto.getDocument() != null && dto.getDocument().getId() != null){
                item.setDocument(new Document());
                item.getDocument().setId(dto.getDocument().getId());
            }

            if(this.utilisateur && dto.getUtilisateur()!=null &&  dto.getUtilisateur().getId() != null)
                item.setUtilisateur(utilisateurConverter.toItem(dto.getUtilisateur())) ;

            if(this.acessManagement && dto.getAcessManagement()!=null &&  dto.getAcessManagement().getId() != null)
                item.setAcessManagement(acessManagementConverter.toItem(dto.getAcessManagement())) ;



        return item;
        }
    }

    @Override
    public DocumentManagementUtilisateurDto toDto(DocumentManagementUtilisateur item) {
        if (item == null) {
            return null;
        } else {
            DocumentManagementUtilisateurDto dto = new DocumentManagementUtilisateurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateManagement()!=null)
                dto.setDateManagement(DateUtil.dateTimeToString(item.getDateManagement()));
        if(this.document && item.getDocument()!=null) {
            dto.setDocument(documentConverter.toDto(item.getDocument())) ;
        }
        if(this.utilisateur && item.getUtilisateur()!=null) {
            dto.setUtilisateur(utilisateurConverter.toDto(item.getUtilisateur())) ;
        }
        if(this.acessManagement && item.getAcessManagement()!=null) {
            dto.setAcessManagement(acessManagementConverter.toDto(item.getAcessManagement())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.document = value;
        this.utilisateur = value;
        this.acessManagement = value;
    }


    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public DocumentConverter getDocumentConverter(){
        return this.documentConverter;
    }
    public void setDocumentConverter(DocumentConverter documentConverter ){
        this.documentConverter = documentConverter;
    }
    public AcessManagementConverter getAcessManagementConverter(){
        return this.acessManagementConverter;
    }
    public void setAcessManagementConverter(AcessManagementConverter acessManagementConverter ){
        this.acessManagementConverter = acessManagementConverter;
    }
    public boolean  isDocument(){
        return this.document;
    }
    public void  setDocument(boolean document){
        this.document = document;
    }
    public boolean  isUtilisateur(){
        return this.utilisateur;
    }
    public void  setUtilisateur(boolean utilisateur){
        this.utilisateur = utilisateur;
    }
    public boolean  isAcessManagement(){
        return this.acessManagement;
    }
    public void  setAcessManagement(boolean acessManagement){
        this.acessManagement = acessManagement;
    }
}
