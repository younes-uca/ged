package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.Client;
import ma.sir.ana.dao.criteria.core.ClientCriteria;
import ma.sir.ana.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface ClientAdminService extends  IService<Client,ClientCriteria, ClientHistoryCriteria>  {

    List<Client> findByClientCategoryId(Long id);
    int deleteByClientCategoryId(Long id);



}
