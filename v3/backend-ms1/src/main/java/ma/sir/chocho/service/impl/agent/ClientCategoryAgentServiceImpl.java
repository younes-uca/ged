package ma.sir.chocho.service.impl.agent;

import ma.sir.chocho.bean.core.ClientCategory;
import ma.sir.chocho.bean.history.ClientCategoryHistory;
import ma.sir.chocho.dao.criteria.core.ClientCategoryCriteria;
import ma.sir.chocho.dao.criteria.history.ClientCategoryHistoryCriteria;
import ma.sir.chocho.dao.facade.core.ClientCategoryDao;
import ma.sir.chocho.dao.facade.history.ClientCategoryHistoryDao;
import ma.sir.chocho.dao.specification.core.ClientCategorySpecification;
import ma.sir.chocho.service.facade.agent.ClientCategoryAgentService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class ClientCategoryAgentServiceImpl extends AbstractServiceImpl<ClientCategory,ClientCategoryHistory, ClientCategoryCriteria, ClientCategoryHistoryCriteria, ClientCategoryDao,
ClientCategoryHistoryDao> implements ClientCategoryAgentService {



    public ClientCategory findByReferenceEntity(ClientCategory t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(ClientCategory.class,ClientCategoryHistory.class, ClientCategoryHistoryCriteria.class, ClientCategorySpecification.class);
    }


    public ClientCategoryAgentServiceImpl(ClientCategoryDao dao, ClientCategoryHistoryDao historyDao) {
        super(dao, historyDao);
    }

}