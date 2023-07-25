package  ma.sir.easy.dao.specification.core;

import ma.sir.easy.zynerator.specification.AbstractSpecification;
import ma.sir.easy.dao.criteria.core.DocumentAcessShareCriteria;
import ma.sir.easy.bean.core.DocumentAcessShare;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DocumentAcessShareSpecification extends  AbstractSpecification<DocumentAcessShareCriteria, DocumentAcessShare>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("document","id", criteria.getDocument()==null?null:criteria.getDocument().getId());
        addPredicateFk("document","id", criteria.getDocuments());
        addPredicateFk("document","reference", criteria.getDocument()==null?null:criteria.getDocument().getReference());
        addPredicateFk("acessShare","id", criteria.getAcessShare()==null?null:criteria.getAcessShare().getId());
        addPredicateFk("acessShare","id", criteria.getAcessShares());
        addPredicateFk("acessShare","code", criteria.getAcessShare()==null?null:criteria.getAcessShare().getCode());
    }

    public DocumentAcessShareSpecification(DocumentAcessShareCriteria criteria) {
        super(criteria);
    }

    public DocumentAcessShareSpecification(DocumentAcessShareCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
