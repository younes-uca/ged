package  ma.sir.ged.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ged.bean.core.Document;

import ma.sir.ged.zynerator.util.StringUtil;
import ma.sir.ged.zynerator.converter.AbstractConverter;
import ma.sir.ged.zynerator.util.DateUtil;
import ma.sir.ged.bean.history.DocumentAcessShareHistory;
import ma.sir.ged.bean.core.DocumentAcessShare;
import ma.sir.ged.ws.dto.DocumentAcessShareDto;

@Component
public class DocumentAcessShareConverter extends AbstractConverter<DocumentAcessShare, DocumentAcessShareDto, DocumentAcessShareHistory> {

    @Autowired
    private DocumentConverter documentConverter ;
    @Autowired
    private AcessShareConverter acessShareConverter ;
    private boolean document;
    private boolean acessShare;

    public  DocumentAcessShareConverter(){
        super(DocumentAcessShare.class, DocumentAcessShareDto.class, DocumentAcessShareHistory.class);
    }

    @Override
    public DocumentAcessShare toItem(DocumentAcessShareDto dto) {
        if (dto == null) {
            return null;
        } else {
        DocumentAcessShare item = new DocumentAcessShare();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getDocument() != null && dto.getDocument().getId() != null){
                item.setDocument(new Document());
                item.getDocument().setId(dto.getDocument().getId());
            }

            if(this.acessShare && dto.getAcessShare()!=null &&  dto.getAcessShare().getId() != null)
                item.setAcessShare(acessShareConverter.toItem(dto.getAcessShare())) ;



        return item;
        }
    }

    @Override
    public DocumentAcessShareDto toDto(DocumentAcessShare item) {
        if (item == null) {
            return null;
        } else {
            DocumentAcessShareDto dto = new DocumentAcessShareDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.document && item.getDocument()!=null) {
            dto.setDocument(documentConverter.toDto(item.getDocument())) ;
        }
        if(this.acessShare && item.getAcessShare()!=null) {
            dto.setAcessShare(acessShareConverter.toDto(item.getAcessShare())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.document = value;
        this.acessShare = value;
    }


    public DocumentConverter getDocumentConverter(){
        return this.documentConverter;
    }
    public void setDocumentConverter(DocumentConverter documentConverter ){
        this.documentConverter = documentConverter;
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
    public boolean  isAcessShare(){
        return this.acessShare;
    }
    public void  setAcessShare(boolean acessShare){
        this.acessShare = acessShare;
    }
}
