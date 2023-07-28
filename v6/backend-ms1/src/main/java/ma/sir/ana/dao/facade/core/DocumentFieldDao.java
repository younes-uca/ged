package ma.sir.ana.dao.facade.core;

import ma.sir.ana.zynerator.repository.AbstractRepository;
import ma.sir.ana.bean.core.DocumentField;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentFieldDao extends AbstractRepository<DocumentField,Long>  {

    List<DocumentField> findByFieldId(Long id);
    int deleteByFieldId(Long id);
    List<DocumentField> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentField> findByDocumentFieldStateId(Long id);
    int deleteByDocumentFieldStateId(Long id);

}
