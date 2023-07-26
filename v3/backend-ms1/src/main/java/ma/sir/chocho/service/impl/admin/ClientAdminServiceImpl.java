package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.Client;
import ma.sir.chocho.bean.history.ClientHistory;
import ma.sir.chocho.dao.criteria.core.ClientCriteria;
import ma.sir.chocho.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.chocho.dao.facade.core.ClientDao;
import ma.sir.chocho.dao.facade.history.ClientHistoryDao;
import ma.sir.chocho.dao.specification.core.ClientSpecification;
import ma.sir.chocho.service.facade.admin.ClientAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.chocho.service.facade.admin.ClientCategoryAdminService ;



import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client,ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientDao,
ClientHistoryDao> implements ClientAdminService {



    public Client findByReferenceEntity(Client t){
        return  dao.findByEmail(t.getEmail());
    }

    public List<Client> findByClientCategoryId(Long id){
        return dao.findByClientCategoryId(id);
    }
    public int deleteByClientCategoryId(Long id){
        return dao.deleteByClientCategoryId(id);
    }




    public void configure() {
        super.configure(Client.class,ClientHistory.class, ClientHistoryCriteria.class, ClientSpecification.class);
    }

    @Autowired
    private ClientCategoryAdminService clientCategoryService ;

    public ClientAdminServiceImpl(ClientDao dao, ClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}