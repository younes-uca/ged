package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.ClientCategory;
import ma.sir.ana.dao.criteria.core.ClientCategoryCriteria;
import ma.sir.ana.dao.criteria.history.ClientCategoryHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface ClientCategoryAdminService extends  IService<ClientCategory,ClientCategoryCriteria, ClientCategoryHistoryCriteria>  {




}
