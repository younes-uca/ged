package  ma.sir.ana.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ana.zynerator.util.StringUtil;
import ma.sir.ana.zynerator.converter.AbstractConverter;
import ma.sir.ana.zynerator.util.DateUtil;
import ma.sir.ana.bean.history.AcessManagementHistory;
import ma.sir.ana.bean.core.AcessManagement;
import ma.sir.ana.ws.dto.AcessManagementDto;

@Component
public class AcessManagementConverter extends AbstractConverter<AcessManagement, AcessManagementDto, AcessManagementHistory> {


    public  AcessManagementConverter(){
        super(AcessManagement.class, AcessManagementDto.class, AcessManagementHistory.class);
    }

    @Override
    public AcessManagement toItem(AcessManagementDto dto) {
        if (dto == null) {
            return null;
        } else {
        AcessManagement item = new AcessManagement();
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
    public AcessManagementDto toDto(AcessManagement item) {
        if (item == null) {
            return null;
        } else {
            AcessManagementDto dto = new AcessManagementDto();
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
