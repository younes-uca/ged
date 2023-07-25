package  ma.sir.easy.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easy.zynerator.util.StringUtil;
import ma.sir.easy.zynerator.converter.AbstractConverter;
import ma.sir.easy.zynerator.util.DateUtil;
import ma.sir.easy.bean.history.AcessShareHistory;
import ma.sir.easy.bean.core.AcessShare;
import ma.sir.easy.ws.dto.AcessShareDto;

@Component
public class AcessShareConverter extends AbstractConverter<AcessShare, AcessShareDto, AcessShareHistory> {


    public  AcessShareConverter(){
        super(AcessShare.class, AcessShareDto.class, AcessShareHistory.class);
    }

    @Override
    public AcessShare toItem(AcessShareDto dto) {
        if (dto == null) {
            return null;
        } else {
        AcessShare item = new AcessShare();
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
    public AcessShareDto toDto(AcessShare item) {
        if (item == null) {
            return null;
        } else {
            AcessShareDto dto = new AcessShareDto();
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
