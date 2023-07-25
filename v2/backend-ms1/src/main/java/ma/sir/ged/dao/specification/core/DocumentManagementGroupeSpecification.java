package  ma.sir.ged.dao.specification.core;

import ma.sir.ged.zynerator.specification.AbstractSpecification;
import ma.sir.ged.dao.criteria.core.DocumentManagementGroupeCriteria;
import ma.sir.ged.bean.core.DocumentManagementGroupe;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DocumentManagementGroupeSpecification extends  AbstractSpecification<DocumentManagementGroupeCriteria, DocumentManagementGroupe>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateManagement", criteria.getDateManagement(), criteria.getDateManagementFrom(), criteria.getDateManagementTo());
        addPredicateFk("document","id", criteria.getDocument()==null?null:criteria.getDocument().getId());
        addPredicateFk("document","id", criteria.getDocuments());
        addPredicateFk("document","reference", criteria.getDocument()==null?null:criteria.getDocument().getReference());
        addPredicateFk("groupe","id", criteria.getGroupe()==null?null:criteria.getGroupe().getId());
        addPredicateFk("groupe","id", criteria.getGroupes());
        addPredicateFk("groupe","code", criteria.getGroupe()==null?null:criteria.getGroupe().getCode());
        addPredicateFk("acessManagement","id", criteria.getAcessManagement()==null?null:criteria.getAcessManagement().getId());
        addPredicateFk("acessManagement","id", criteria.getAcessManagements());
        addPredicateFk("acessManagement","code", criteria.getAcessManagement()==null?null:criteria.getAcessManagement().getCode());
    }

    public DocumentManagementGroupeSpecification(DocumentManagementGroupeCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementGroupeSpecification(DocumentManagementGroupeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
