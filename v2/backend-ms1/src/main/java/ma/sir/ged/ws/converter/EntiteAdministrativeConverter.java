package  ma.sir.ged.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ged.zynerator.util.StringUtil;
import ma.sir.ged.zynerator.converter.AbstractConverter;
import ma.sir.ged.zynerator.util.DateUtil;
import ma.sir.ged.bean.history.EntiteAdministrativeHistory;
import ma.sir.ged.bean.core.EntiteAdministrative;
import ma.sir.ged.ws.dto.EntiteAdministrativeDto;

@Component
public class EntiteAdministrativeConverter extends AbstractConverter<EntiteAdministrative, EntiteAdministrativeDto, EntiteAdministrativeHistory> {

    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    private boolean utilisateur;

    public  EntiteAdministrativeConverter(){
        super(EntiteAdministrative.class, EntiteAdministrativeDto.class, EntiteAdministrativeHistory.class);
    }

    @Override
    public EntiteAdministrative toItem(EntiteAdministrativeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntiteAdministrative item = new EntiteAdministrative();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.utilisateur && dto.getUtilisateur()!=null &&  dto.getUtilisateur().getId() != null)
                item.setUtilisateur(utilisateurConverter.toItem(dto.getUtilisateur())) ;



        return item;
        }
    }

    @Override
    public EntiteAdministrativeDto toDto(EntiteAdministrative item) {
        if (item == null) {
            return null;
        } else {
            EntiteAdministrativeDto dto = new EntiteAdministrativeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.utilisateur && item.getUtilisateur()!=null) {
            dto.setUtilisateur(utilisateurConverter.toDto(item.getUtilisateur())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.utilisateur = value;
    }


    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public boolean  isUtilisateur(){
        return this.utilisateur;
    }
    public void  setUtilisateur(boolean utilisateur){
        this.utilisateur = utilisateur;
    }
}
