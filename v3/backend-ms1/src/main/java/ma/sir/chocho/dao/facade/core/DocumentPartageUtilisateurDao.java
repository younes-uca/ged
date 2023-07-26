package ma.sir.chocho.dao.facade.core;

import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.DocumentPartageUtilisateur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentPartageUtilisateurDao extends AbstractRepository<DocumentPartageUtilisateur,Long>  {

    List<DocumentPartageUtilisateur> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentPartageUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);
    List<DocumentPartageUtilisateur> findByAcessShareId(Long id);
    int deleteByAcessShareId(Long id);

}
