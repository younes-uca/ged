package ma.sir.ana.zynerator.service;

import ma.sir.ana.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.ana.zynerator.criteria.BaseCriteria;
import ma.sir.ana.zynerator.history.HistBusinessObject;
import ma.sir.ana.zynerator.history.HistCriteria;
import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}