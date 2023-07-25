package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.Tag;
import ma.sir.easy.bean.history.TagHistory;
import ma.sir.easy.dao.criteria.core.TagCriteria;
import ma.sir.easy.dao.criteria.history.TagHistoryCriteria;
import ma.sir.easy.dao.facade.core.TagDao;
import ma.sir.easy.dao.facade.history.TagHistoryDao;
import ma.sir.easy.dao.specification.core.TagSpecification;
import ma.sir.easy.service.facade.admin.TagAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class TagAdminServiceImpl extends AbstractServiceImpl<Tag,TagHistory, TagCriteria, TagHistoryCriteria, TagDao,
TagHistoryDao> implements TagAdminService {



    public Tag findByReferenceEntity(Tag t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Tag.class,TagHistory.class, TagHistoryCriteria.class, TagSpecification.class);
    }


    public TagAdminServiceImpl(TagDao dao, TagHistoryDao historyDao) {
        super(dao, historyDao);
    }

}