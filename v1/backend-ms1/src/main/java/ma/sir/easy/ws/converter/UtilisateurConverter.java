package  ma.sir.easy.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easy.zynerator.util.StringUtil;
import ma.sir.easy.zynerator.converter.AbstractConverter;
import ma.sir.easy.zynerator.util.DateUtil;
import ma.sir.easy.bean.history.UtilisateurHistory;
import ma.sir.easy.bean.core.Utilisateur;
import ma.sir.easy.ws.dto.UtilisateurDto;

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
