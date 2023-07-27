package  ma.sir.ana.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ana.bean.core.Groupe;

import ma.sir.ana.zynerator.util.StringUtil;
import ma.sir.ana.zynerator.converter.AbstractConverter;
import ma.sir.ana.zynerator.util.DateUtil;
import ma.sir.ana.bean.history.GroupeUtilisateurHistory;
import ma.sir.ana.bean.core.GroupeUtilisateur;
import ma.sir.ana.ws.dto.GroupeUtilisateurDto;

@Component
public class GroupeUtilisateurConverter extends AbstractConverter<GroupeUtilisateur, GroupeUtilisateurDto, GroupeUtilisateurHistory> {

    @Autowired
    private GroupeConverter groupeConverter ;
    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    private boolean groupe;
    private boolean utilisateur;

    public  GroupeUtilisateurConverter(){
        super(GroupeUtilisateur.class, GroupeUtilisateurDto.class, GroupeUtilisateurHistory.class);
    }

    @Override
    public GroupeUtilisateur toItem(GroupeUtilisateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        GroupeUtilisateur item = new GroupeUtilisateur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getGroupe() != null && dto.getGroupe().getId() != null){
                item.setGroupe(new Groupe());
                item.getGroupe().setId(dto.getGroupe().getId());
            }

            if(this.utilisateur && dto.getUtilisateur()!=null &&  dto.getUtilisateur().getId() != null)
                item.setUtilisateur(utilisateurConverter.toItem(dto.getUtilisateur())) ;



        return item;
        }
    }

    @Override
    public GroupeUtilisateurDto toDto(GroupeUtilisateur item) {
        if (item == null) {
            return null;
        } else {
            GroupeUtilisateurDto dto = new GroupeUtilisateurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.groupe && item.getGroupe()!=null) {
            dto.setGroupe(groupeConverter.toDto(item.getGroupe())) ;
        }
        if(this.utilisateur && item.getUtilisateur()!=null) {
            dto.setUtilisateur(utilisateurConverter.toDto(item.getUtilisateur())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.groupe = value;
        this.utilisateur = value;
    }


    public GroupeConverter getGroupeConverter(){
        return this.groupeConverter;
    }
    public void setGroupeConverter(GroupeConverter groupeConverter ){
        this.groupeConverter = groupeConverter;
    }
    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public boolean  isGroupe(){
        return this.groupe;
    }
    public void  setGroupe(boolean groupe){
        this.groupe = groupe;
    }
    public boolean  isUtilisateur(){
        return this.utilisateur;
    }
    public void  setUtilisateur(boolean utilisateur){
        this.utilisateur = utilisateur;
    }
}
