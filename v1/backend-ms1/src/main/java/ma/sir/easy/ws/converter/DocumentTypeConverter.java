package  ma.sir.easy.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easy.zynerator.util.StringUtil;
import ma.sir.easy.zynerator.converter.AbstractConverter;
import ma.sir.easy.zynerator.util.DateUtil;
import ma.sir.easy.bean.history.DocumentTypeHistory;
import ma.sir.easy.bean.core.DocumentType;
import ma.sir.easy.ws.dto.DocumentTypeDto;

@Component
public class DocumentTypeConverter extends AbstractConverter<DocumentType, DocumentTypeDto, DocumentTypeHistory> {


    public  DocumentTypeConverter(){
        super(DocumentType.class, DocumentTypeDto.class, DocumentTypeHistory.class);
    }

    @Override
    public DocumentType toItem(DocumentTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
        DocumentType item = new DocumentType();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());


        return item;
        }
    }

    @Override
    public DocumentTypeDto toDto(DocumentType item) {
        if (item == null) {
            return null;
        } else {
            DocumentTypeDto dto = new DocumentTypeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
