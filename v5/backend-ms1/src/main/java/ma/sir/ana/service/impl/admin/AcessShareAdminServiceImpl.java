package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.AcessShare;
import ma.sir.ana.bean.history.AcessShareHistory;
import ma.sir.ana.dao.criteria.core.AcessShareCriteria;
import ma.sir.ana.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.ana.dao.facade.core.AcessShareDao;
import ma.sir.ana.dao.facade.history.AcessShareHistoryDao;
import ma.sir.ana.dao.specification.core.AcessShareSpecification;
import ma.sir.ana.service.facade.admin.AcessShareAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
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