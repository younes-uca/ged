package ma.sir.ana.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ana.zynerator.repository.AbstractRepository;
import ma.sir.ana.bean.core.Utilisateur;
import org.springframework.stereotype.Repository;
import ma.sir.ana.bean.core.Utilisateur;
import java.util.List;


@Repository
public interface UtilisateurDao extends AbstractRepository<Utilisateur,Long>  {
    Utilisateur findByEmail(String email);
    int deleteByEmail(String email);


    @Query("SELECT NEW Utilisateur(item.id,item.name) FROM Utilisateur item")
    List<Utilisateur> findAllOptimized();
}
