package  ma.sir.ana.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ana.bean.core.Document;
import ma.sir.ana.bean.core.Groupe;

import ma.sir.ana.zynerator.util.StringUtil;
import ma.sir.ana.zynerator.converter.AbstractConverter;
import ma.sir.ana.zynerator.util.DateUtil;
import ma.sir.ana.bean.history.DocumentManagementGroupeHistory;
import ma.sir.ana.bean.core.DocumentManagementGroupe;
import ma.sir.ana.ws.dto.DocumentManagementGroupeDto;

@Component
public class DocumentManagementGroupeConverter extends AbstractConverter<DocumentManagementGroupe, DocumentManagementGroupeDto, DocumentManagementGroupeHistory> {

    @Autowired
    private DocumentConverter documentConverter ;
    @Autowired
    private AcessManagementConverter acessManagementConverter ;
    @Autowired
    private GroupeConverter groupeConverter ;
    private boolean document;
    private boolean groupe;
    private boolean acessManagement;

    public  DocumentManagementGroupeConverter(){
        super(DocumentManagementGroupe.class, DocumentManagementGroupeDto.class, DocumentManagementGroupeHistory.class);
    }

    @Override
    public DocumentManagementGroupe toItem(DocumentManagementGroupeDto dto) {
        if (dto == null) {
            return null;
        } else {
        DocumentManagementGroupe item = new DocumentManagementGroupe();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateManagement()))
                item.setDateManagement(DateUtil.stringEnToDate(dto.getDateManagement()));
            if(dto.getDocument() != null && dto.getDocument().getId() != null){
                item.setDocument(new Document());
                item.getDocument().setId(dto.getDocument().getId());
            }

            if(dto.getGroupe() != null && dto.getGroupe().getId() != null){
                item.setGroupe(new Groupe());
                item.getGroupe().setId(dto.getGroupe().getId());
            }

            if(this.acessManagement && dto.getAcessManagement()!=null &&  dto.getAcessManagement().getId() != null)
                item.setAcessManagement(acessManagementConverter.toItem(dto.getAcessManagement())) ;



        return item;
        }
    }

    @Override
    public DocumentManagementGroupeDto toDto(DocumentManagementGroupe item) {
        if (item == null) {
            return null;
        } else {
            DocumentManagementGroupeDto dto = new DocumentManagementGroupeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateManagement()!=null)
                dto.setDateManagement(DateUtil.dateTimeToString(item.getDateManagement()));
        if(this.document && item.getDocument()!=null) {
            dto.setDocument(documentConverter.toDto(item.getDocument())) ;
        }
        if(this.groupe && item.getGroupe()!=null) {
            dto.setGroupe(groupeConverter.toDto(item.getGroupe())) ;
        }
        if(this.acessManagement && item.getAcessManagement()!=null) {
            dto.setAcessManagement(acessManagementConverter.toDto(item.getAcessManagement())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.document = value;
        this.groupe = value;
        this.acessManagement = value;
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
    public GroupeConverter getGroupeConverter(){
        return this.groupeConverter;
    }
    public void setGroupeConverter(GroupeConverter groupeConverter ){
        this.groupeConverter = groupeConverter;
    }
    public boolean  isDocument(){
        return this.document;
    }
    public void  setDocument(boolean document){
        this.document = document;
    }
    public boolean  isGroupe(){
        return this.groupe;
    }
    public void  setGroupe(boolean groupe){
        this.groupe = groupe;
    }
    public boolean  isAcessManagement(){
        return this.acessManagement;
    }
    public void  setAcessManagement(boolean acessManagement){
        this.acessManagement = acessManagement;
    }
}
