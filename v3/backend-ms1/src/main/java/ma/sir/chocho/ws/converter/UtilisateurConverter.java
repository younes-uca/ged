package  ma.sir.chocho.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.chocho.zynerator.util.StringUtil;
import ma.sir.chocho.zynerator.converter.AbstractConverter;
import ma.sir.chocho.zynerator.util.DateUtil;
import ma.sir.chocho.bean.history.UtilisateurHistory;
import ma.sir.chocho.bean.core.Utilisateur;
import ma.sir.chocho.ws.dto.UtilisateurDto;

@Component
public class UtilisateurConverter extends AbstractConverter<Utilisateur, UtilisateurDto, UtilisateurHistory> {


    public  UtilisateurConverter(){
        super(Utilisateur.class, UtilisateurDto.class, UtilisateurHistory.class);
    }

    @Override
    public Utilisateur toItem(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        Utilisateur item = new Utilisateur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());


        return item;
        }
    }

    @Override
    public UtilisateurDto toDto(Utilisateur item) {
        if (item == null) {
            return null;
        } else {
            UtilisateurDto dto = new UtilisateurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
