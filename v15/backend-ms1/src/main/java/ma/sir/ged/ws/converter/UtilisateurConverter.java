package  ma.sir.ged.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ged.bean.core.EntiteAdministrative;

import ma.sir.ged.zynerator.util.StringUtil;
import ma.sir.ged.zynerator.converter.AbstractConverter;
import ma.sir.ged.zynerator.util.DateUtil;
import ma.sir.ged.bean.history.UtilisateurHistory;
import ma.sir.ged.bean.core.Utilisateur;
import ma.sir.ged.ws.dto.UtilisateurDto;

@Component
public class UtilisateurConverter extends AbstractConverter<Utilisateur, UtilisateurDto, UtilisateurHistory> {

    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private GenderConverter genderConverter ;
    private boolean gender;
    private boolean entiteAdministrative;

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
            if(StringUtil.isNotEmpty(dto.getTelephone()))
                item.setTelephone(dto.getTelephone());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(StringUtil.isNotEmpty(dto.getDateNaissance()))
                item.setDateNaissance(DateUtil.stringEnToDate(dto.getDateNaissance()));
            if(this.gender && dto.getGender()!=null &&  dto.getGender().getId() != null)
                item.setGender(genderConverter.toItem(dto.getGender())) ;

            if(dto.getEntiteAdministrative() != null && dto.getEntiteAdministrative().getId() != null){
                item.setEntiteAdministrative(new EntiteAdministrative());
                item.getEntiteAdministrative().setId(dto.getEntiteAdministrative().getId());
                item.getEntiteAdministrative().setLibelle(dto.getEntiteAdministrative().getLibelle());
            }



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
            if(StringUtil.isNotEmpty(item.getTelephone()))
                dto.setTelephone(item.getTelephone());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(item.getDateNaissance()!=null)
                dto.setDateNaissance(DateUtil.dateTimeToString(item.getDateNaissance()));
        if(this.gender && item.getGender()!=null) {
            dto.setGender(genderConverter.toDto(item.getGender())) ;
        }
        if(this.entiteAdministrative && item.getEntiteAdministrative()!=null) {
            entiteAdministrativeConverter.setChef(false);
            dto.setEntiteAdministrative(entiteAdministrativeConverter.toDto(item.getEntiteAdministrative())) ;
            entiteAdministrativeConverter.setChef(true);
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.gender = value;
        this.entiteAdministrative = value;
    }


    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public GenderConverter getGenderConverter(){
        return this.genderConverter;
    }
    public void setGenderConverter(GenderConverter genderConverter ){
        this.genderConverter = genderConverter;
    }
    public boolean  isGender(){
        return this.gender;
    }
    public void  setGender(boolean gender){
        this.gender = gender;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
}
