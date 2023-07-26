package ma.sir.chocho.dao.facade.core;

import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.GroupeUtilisateur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface GroupeUtilisateurDao extends AbstractRepository<GroupeUtilisateur,Long>  {

    List<GroupeUtilisateur> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<GroupeUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);

}
