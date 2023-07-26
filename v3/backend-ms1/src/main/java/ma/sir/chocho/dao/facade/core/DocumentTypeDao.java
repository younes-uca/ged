package ma.sir.chocho.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.DocumentType;
import org.springframework.stereotype.Repository;
import ma.sir.chocho.bean.core.DocumentType;
import java.util.List;


@Repository
public interface DocumentTypeDao extends AbstractRepository<DocumentType,Long>  {
    DocumentType findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW DocumentType(item.id,item.libelle) FROM DocumentType item")
    List<DocumentType> findAllOptimized();
}
