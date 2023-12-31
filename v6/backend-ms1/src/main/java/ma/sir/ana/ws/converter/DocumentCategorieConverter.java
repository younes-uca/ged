package  ma.sir.ana.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ana.zynerator.util.ListUtil;


import ma.sir.ana.zynerator.util.StringUtil;
import ma.sir.ana.zynerator.converter.AbstractConverter;
import ma.sir.ana.zynerator.util.DateUtil;
import ma.sir.ana.bean.history.DocumentCategorieHistory;
import ma.sir.ana.bean.core.DocumentCategorie;
import ma.sir.ana.ws.dto.DocumentCategorieDto;

@Component
public class DocumentCategorieConverter extends AbstractConverter<DocumentCategorie, DocumentCategorieDto, DocumentCategorieHistory> {

    @Autowired
    private FieldConverter fieldConverter ;
    @Autowired
    private DocumentCategorieFieldRuleConverter documentCategorieFieldRuleConverter ;
    @Autowired
    private DocumentCategorieFieldConverter documentCategorieFieldConverter ;
    private boolean documentCategorieFields;

    public  DocumentCategorieConverter(){
        super(DocumentCategorie.class, DocumentCategorieDto.class, DocumentCategorieHistory.class);
        init(true);
    }

    @Override
    public DocumentCategorie toItem(DocumentCategorieDto dto) {
        if (dto == null) {
            return null;
        } else {
        DocumentCategorie item = new DocumentCategorie();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());

            if(this.documentCategorieFields && ListUtil.isNotEmpty(dto.getDocumentCategorieFields()))
                item.setDocumentCategorieFields(documentCategorieFieldConverter.toItem(dto.getDocumentCategorieFields()));

        return item;
        }
    }

    @Override
    public DocumentCategorieDto toDto(DocumentCategorie item) {
        if (item == null) {
            return null;
        } else {
            DocumentCategorieDto dto = new DocumentCategorieDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.documentCategorieFields && ListUtil.isNotEmpty(item.getDocumentCategorieFields())){
            documentCategorieFieldConverter.init(true);
            documentCategorieFieldConverter.setDocumentCategorie(false);
            dto.setDocumentCategorieFields(documentCategorieFieldConverter.toDto(item.getDocumentCategorieFields()));
            documentCategorieFieldConverter.setDocumentCategorie(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.documentCategorieFields = value;
    }

    public void initObject(boolean value) {
    }


    public FieldConverter getFieldConverter(){
        return this.fieldConverter;
    }
    public void setFieldConverter(FieldConverter fieldConverter ){
        this.fieldConverter = fieldConverter;
    }
    public DocumentCategorieFieldRuleConverter getDocumentCategorieFieldRuleConverter(){
        return this.documentCategorieFieldRuleConverter;
    }
    public void setDocumentCategorieFieldRuleConverter(DocumentCategorieFieldRuleConverter documentCategorieFieldRuleConverter ){
        this.documentCategorieFieldRuleConverter = documentCategorieFieldRuleConverter;
    }
    public DocumentCategorieFieldConverter getDocumentCategorieFieldConverter(){
        return this.documentCategorieFieldConverter;
    }
    public void setDocumentCategorieFieldConverter(DocumentCategorieFieldConverter documentCategorieFieldConverter ){
        this.documentCategorieFieldConverter = documentCategorieFieldConverter;
    }
    public boolean  isDocumentCategorieFields(){
        return this.documentCategorieFields ;
    }
    public void  setDocumentCategorieFields(boolean documentCategorieFields ){
        this.documentCategorieFields  = documentCategorieFields ;
    }
}
