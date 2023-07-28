package ma.sir.ana.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ana.zynerator.repository.AbstractRepository;
import ma.sir.ana.bean.core.Field;
import org.springframework.stereotype.Repository;
import ma.sir.ana.bean.core.Field;
import java.util.List;


@Repository
public interface FieldDao extends AbstractRepository<Field,Long>  {
    Field findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Field(item.id,item.libelle) FROM Field item")
    List<Field> findAllOptimized();
}
