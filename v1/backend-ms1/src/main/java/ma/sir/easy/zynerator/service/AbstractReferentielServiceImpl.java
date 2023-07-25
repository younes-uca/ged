package ma.sir.easy.zynerator.service;

import ma.sir.easy.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.easy.zynerator.criteria.BaseCriteria;
import ma.sir.easy.zynerator.history.HistBusinessObject;
import ma.sir.easy.zynerator.history.HistCriteria;
import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}