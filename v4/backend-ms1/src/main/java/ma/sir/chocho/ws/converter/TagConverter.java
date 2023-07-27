package  ma.sir.chocho.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.chocho.zynerator.util.StringUtil;
import ma.sir.chocho.zynerator.converter.AbstractConverter;
import ma.sir.chocho.zynerator.util.DateUtil;
import ma.sir.chocho.bean.history.TagHistory;
import ma.sir.chocho.bean.core.Tag;
import ma.sir.chocho.ws.dto.TagDto;

@Component
public class TagConverter extends AbstractConverter<Tag, TagDto, TagHistory> {


    public  TagConverter(){
        super(Tag.class, TagDto.class, TagHistory.class);
    }

    @Override
    public Tag toItem(TagDto dto) {
        if (dto == null) {
            return null;
        } else {
        Tag item = new Tag();
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
    public TagDto toDto(Tag item) {
        if (item == null) {
            return null;
        } else {
            TagDto dto = new TagDto();
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
