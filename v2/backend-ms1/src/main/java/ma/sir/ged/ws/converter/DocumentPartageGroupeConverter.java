package  ma.sir.ged.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ged.bean.core.Document;
import ma.sir.ged.bean.core.Groupe;

import ma.sir.ged.zynerator.util.StringUtil;
import ma.sir.ged.zynerator.converter.AbstractConverter;
import ma.sir.ged.zynerator.util.DateUtil;
import ma.sir.ged.bean.history.DocumentPartageGroupeHistory;
import ma.sir.ged.bean.core.DocumentPartageGroupe;
import ma.sir.ged.ws.dto.DocumentPartageGroupeDto;

@Component
public class DocumentPartageGroupeConverter extends AbstractConverter<DocumentPartageGroupe, DocumentPartageGroupeDto, DocumentPartageGroupeHistory> {

    @Autowired
    private DocumentConverter documentConverter ;
    @Autowired
    private GroupeConverter groupeConverter ;
    @Autowired
    private AcessShareConverter acessShareConverter ;
    private boolean document;
    private boolean groupe;
    private boolean acessShare;

    public  DocumentPartageGroupeConverter(){
        super(DocumentPartageGroupe.class, DocumentPartageGroupeDto.class, DocumentPartageGroupeHistory.class);
    }

    @Override
    public DocumentPartageGroupe toItem(DocumentPartageGroupeDto dto) {
        if (dto == null) {
            return null;
        } else {
        DocumentPartageGroupe item = new DocumentPartageGroupe();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateShare()))
                item.setDateShare(DateUtil.stringEnToDate(dto.getDateShare()));
            if(dto.getDocument() != null && dto.getDocument().getId() != null){
                item.setDocument(new Document());
                item.getDocument().setId(dto.getDocument().getId());
            }

            if(dto.getGroupe() != null && dto.getGroupe().getId() != null){
                item.setGroupe(new Groupe());
                item.getGroupe().setId(dto.getGroupe().getId());
            }

            if(this.acessShare && dto.getAcessShare()!=null &&  dto.getAcessShare().getId() != null)
                item.setAcessShare(acessShareConverter.toItem(dto.getAcessShare())) ;



        return item;
        }
    }

    @Override
    public DocumentPartageGroupeDto toDto(DocumentPartageGroupe item) {
        if (item == null) {
            return null;
        } else {
            DocumentPartageGroupeDto dto = new DocumentPartageGroupeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateShare()!=null)
                dto.setDateShare(DateUtil.dateTimeToString(item.getDateShare()));
        if(this.document && item.getDocument()!=null) {
            dto.setDocument(documentConverter.toDto(item.getDocument())) ;
        }
        if(this.groupe && item.getGroupe()!=null) {
            dto.setGroupe(groupeConverter.toDto(item.getGroupe())) ;
        }
        if(this.acessShare && item.getAcessShare()!=null) {
            dto.setAcessShare(acessShareConverter.toDto(item.getAcessShare())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.document = value;
        this.groupe = value;
        this.acessShare = value;
    }


    public DocumentConverter getDocumentConverter(){
        return this.documentConverter;
    }
    public void setDocumentConverter(DocumentConverter documentConverter ){
        this.documentConverter = documentConverter;
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
    public boolean  isAcessShare(){
        return this.acessShare;
    }
    public void  setAcessShare(boolean acessShare){
        this.acessShare = acessShare;
    }
}
