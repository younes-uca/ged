package ma.sir.chocho.dao.facade.core;

import ma.sir.chocho.zynerator.repository.AbstractRepository;
import ma.sir.chocho.bean.core.DocumentTag;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentTagDao extends AbstractRepository<DocumentTag,Long>  {

    List<DocumentTag> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentTag> findByTagId(Long id);
    int deleteByTagId(Long id);

}
