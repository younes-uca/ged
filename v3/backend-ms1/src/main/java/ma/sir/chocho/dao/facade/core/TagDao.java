package ma.sir.chocho.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.Tag;
import org.springframework.stereotype.Repository;
import ma.sir.chocho.bean.core.Tag;
import java.util.List;


@Repository
public interface TagDao extends AbstractRepository<Tag,Long>  {
    Tag findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Tag(item.id,item.libelle) FROM Tag item")
    List<Tag> findAllOptimized();
}
