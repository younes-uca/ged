package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.Tag;
import ma.sir.ana.bean.history.TagHistory;
import ma.sir.ana.dao.criteria.core.TagCriteria;
import ma.sir.ana.dao.criteria.history.TagHistoryCriteria;
import ma.sir.ana.dao.facade.core.TagDao;
import ma.sir.ana.dao.facade.history.TagHistoryDao;
import ma.sir.ana.dao.specification.core.TagSpecification;
import ma.sir.ana.service.facade.admin.TagAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
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