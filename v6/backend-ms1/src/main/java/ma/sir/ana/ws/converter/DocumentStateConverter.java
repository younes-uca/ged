package  ma.sir.ana.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ana.zynerator.util.StringUtil;
import ma.sir.ana.zynerator.converter.AbstractConverter;
import ma.sir.ana.zynerator.util.DateUtil;
import ma.sir.ana.bean.history.DocumentStateHistory;
import ma.sir.ana.bean.core.DocumentState;
import ma.sir.ana.ws.dto.DocumentStateDto;

@Component
public class DocumentStateConverter extends AbstractConverter<DocumentState, DocumentStateDto, DocumentStateHistory> {


    public  DocumentStateConverter(){
        super(DocumentState.class, DocumentStateDto.class, DocumentStateHistory.class);
    }

    @Override
    public DocumentState toItem(DocumentStateDto dto) {
        if (dto == null) {
            return null;
        } else {
        DocumentState item = new DocumentState();
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
    public DocumentStateDto toDto(DocumentState item) {
        if (item == null) {
            return null;
        } else {
            DocumentStateDto dto = new DocumentStateDto();
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
