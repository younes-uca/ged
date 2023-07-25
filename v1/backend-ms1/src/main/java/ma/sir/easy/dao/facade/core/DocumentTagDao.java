package ma.sir.easy.dao.facade.core;

import ma.sir.easy.zynerator.repository.AbstractRepository;
import ma.sir.easy.bean.core.DocumentTag;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentTagDao extends AbstractRepository<DocumentTag,Long>  {

    List<DocumentTag> findByDocumentId(Long id);
    int deleteByDocumentId(Long id);
    List<DocumentTag> findByTagId(Long id);
    int deleteByTagId(Long id);

}
