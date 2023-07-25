package ma.sir.ged.service.impl.admin;

import ma.sir.ged.bean.core.AcessShare;
import ma.sir.ged.bean.history.AcessShareHistory;
import ma.sir.ged.dao.criteria.core.AcessShareCriteria;
import ma.sir.ged.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.ged.dao.facade.core.AcessShareDao;
import ma.sir.ged.dao.facade.history.AcessShareHistoryDao;
import ma.sir.ged.dao.specification.core.AcessShareSpecification;
import ma.sir.ged.service.facade.admin.AcessShareAdminService;
import ma.sir.ged.zynerator.service.AbstractServiceImpl;
import ma.sir.ged.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class AcessShareAdminServiceImpl extends AbstractServiceImpl<AcessShare,AcessShareHistory, AcessShareCriteria, AcessShareHistoryCriteria, AcessShareDao,
AcessShareHistoryDao> implements AcessShareAdminService {



    public AcessShare findByReferenceEntity(AcessShare t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(AcessShare.class,AcessShareHistory.class, AcessShareHistoryCriteria.class, AcessShareSpecification.class);
    }


    public AcessShareAdminServiceImpl(AcessShareDao dao, AcessShareHistoryDao historyDao) {
        super(dao, historyDao);
    }

}