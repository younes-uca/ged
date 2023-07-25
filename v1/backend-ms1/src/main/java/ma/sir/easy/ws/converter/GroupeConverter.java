package  ma.sir.easy.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easy.zynerator.util.ListUtil;


import ma.sir.easy.zynerator.util.StringUtil;
import ma.sir.easy.zynerator.converter.AbstractConverter;
import ma.sir.easy.zynerator.util.DateUtil;
import ma.sir.easy.bean.history.GroupeHistory;
import ma.sir.easy.bean.core.Groupe;
import ma.sir.easy.ws.dto.GroupeDto;

@Component
public class GroupeConverter extends AbstractConverter<Groupe, GroupeDto, GroupeHistory> {

    @Autowired
    private GroupeUtilisateurConverter groupeUtilisateurConverter ;
    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    private boolean utilisateur;
    private boolean groupeUtilisateurs;

    public  GroupeConverter(){
        super(Groupe.class, GroupeDto.class, GroupeHistory.class);
        init(true);
    }

    @Override
    public Groupe toItem(GroupeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Groupe item = new Groupe();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.utilisateur && dto.getUtilisateur()!=null &&  dto.getUtilisateur().getId() != null)
                item.setUtilisateur(utilisateurConverter.toItem(dto.getUtilisateur())) ;


            if(this.groupeUtilisateurs && ListUtil.isNotEmpty(dto.getGroupeUtilisateurs()))
                item.setGroupeUtilisateurs(groupeUtilisateurConverter.toItem(dto.getGroupeUtilisateurs()));

        return item;
        }
    }

    @Override
    public GroupeDto toDto(Groupe item) {
        if (item == null) {
            return null;
        } else {
            GroupeDto dto = new GroupeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.utilisateur && item.getUtilisateur()!=null) {
            dto.setUtilisateur(utilisateurConverter.toDto(item.getUtilisateur())) ;
        }
        if(this.groupeUtilisateurs && ListUtil.isNotEmpty(item.getGroupeUtilisateurs())){
            groupeUtilisateurConverter.init(true);
            groupeUtilisateurConverter.setGroupe(false);
            dto.setGroupeUtilisateurs(groupeUtilisateurConverter.toDto(item.getGroupeUtilisateurs()));
            groupeUtilisateurConverter.setGroupe(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.groupeUtilisateurs = value;
    }

    public void initObject(boolean value) {
        this.utilisateur = value;
    }


    public GroupeUtilisateurConverter getGroupeUtilisateurConverter(){
        return this.groupeUtilisateurConverter;
    }
    public void setGroupeUtilisateurConverter(GroupeUtilisateurConverter groupeUtilisateurConverter ){
        this.groupeUtilisateurConverter = groupeUtilisateurConverter;
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
    public boolean  isGroupeUtilisateurs(){
        return this.groupeUtilisateurs ;
    }
    public void  setGroupeUtilisateurs(boolean groupeUtilisateurs ){
        this.groupeUtilisateurs  = groupeUtilisateurs ;
    }
}
