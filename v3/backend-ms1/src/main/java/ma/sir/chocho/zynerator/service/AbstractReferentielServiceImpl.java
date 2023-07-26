package ma.sir.chocho.zynerator.service;

import ma.sir.chocho.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.chocho.zynerator.criteria.BaseCriteria;
import ma.sir.chocho.zynerator.history.HistBusinessObject;
import ma.sir.chocho.zynerator.history.HistCriteria;
import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}