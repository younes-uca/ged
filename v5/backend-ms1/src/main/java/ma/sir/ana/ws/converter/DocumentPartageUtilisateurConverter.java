package  ma.sir.ana.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ana.bean.core.Document;

import ma.sir.ana.zynerator.util.StringUtil;
import ma.sir.ana.zynerator.converter.AbstractConverter;
import ma.sir.ana.zynerator.util.DateUtil;
import ma.sir.ana.bean.history.DocumentPartageUtilisateurHistory;
import ma.sir.ana.bean.core.DocumentPartageUtilisateur;
import ma.sir.ana.ws.dto.DocumentPartageUtilisateurDto;

@Component
public class DocumentPartageUtilisateurConverter extends AbstractConverter<DocumentPartageUtilisateur, DocumentPartageUtilisateurDto, DocumentPartageUtilisateurHistory> {

    @Autowired
    private DocumentConverter documentConverter ;
    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    @Autowired
    private AcessShareConverter acessShareConverter ;
    private boolean document;
    private boolean utilisateur;
    private boolean acessShare;

    public  DocumentPartageUtilisateurConverter(){
        super(DocumentPartageUtilisateur.class, DocumentPartageUtilisateurDto.class, DocumentPartageUtilisateurHistory.class);
    }

    @Override
    public DocumentPartageUtilisateur toItem(DocumentPartageUtilisateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        DocumentPartageUtilisateur item = new DocumentPartageUtilisateur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateShare()))
                item.setDateShare(DateUtil.stringEnToDate(dto.getDateShare()));
            if(dto.getDocument() != null && dto.getDocument().getId() != null){
                item.setDocument(new Document());
                item.getDocument().setId(dto.getDocument().getId());
            }

            if(this.utilisateur && dto.getUtilisateur()!=null &&  dto.getUtilisateur().getId() != null)
                item.setUtilisateur(utilisateurConverter.toItem(dto.getUtilisateur())) ;

            if(this.acessShare && dto.getAcessShare()!=null &&  dto.getAcessShare().getId() != null)
                item.setAcessShare(acessShareConverter.toItem(dto.getAcessShare())) ;



        return item;
        }
    }

    @Override
    public DocumentPartageUtilisateurDto toDto(DocumentPartageUtilisateur item) {
        if (item == null) {
            return null;
        } else {
            DocumentPartageUtilisateurDto dto = new DocumentPartageUtilisateurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateShare()!=null)
                dto.setDateShare(DateUtil.dateTimeToString(item.getDateShare()));
        if(this.document && item.getDocument()!=null) {
            dto.setDocument(documentConverter.toDto(item.getDocument())) ;
        }
        if(this.utilisateur && item.getUtilisateur()!=null) {
            dto.setUtilisateur(utilisateurConverter.toDto(item.getUtilisateur())) ;
        }
        if(this.acessShare && item.getAcessShare()!=null) {
            dto.setAcessShare(acessShareConverter.toDto(item.getAcessShare())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.document = value;
        this.utilisateur = value;
        this.acessShare = value;
    }


    public DocumentConverter getDocumentConverter(){
        return this.documentConverter;
    }
    public void setDocumentConverter(DocumentConverter documentConverter ){
        this.documentConverter = documentConverter;
    }
    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
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
    public boolean  isUtilisateur(){
        return this.utilisateur;
    }
    public void  setUtilisateur(boolean utilisateur){
        this.utilisateur = utilisateur;
    }
    public boolean  isAcessShare(){
        return this.acessShare;
    }
    public void  setAcessShare(boolean acessShare){
        this.acessShare = acessShare;
    }
}
