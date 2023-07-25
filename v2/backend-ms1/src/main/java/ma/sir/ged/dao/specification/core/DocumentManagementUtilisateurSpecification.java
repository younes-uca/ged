package  ma.sir.ged.dao.specification.core;

import ma.sir.ged.zynerator.specification.AbstractSpecification;
import ma.sir.ged.dao.criteria.core.DocumentManagementUtilisateurCriteria;
import ma.sir.ged.bean.core.DocumentManagementUtilisateur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DocumentManagementUtilisateurSpecification extends  AbstractSpecification<DocumentManagementUtilisateurCriteria, DocumentManagementUtilisateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateManagement", criteria.getDateManagement(), criteria.getDateManagementFrom(), criteria.getDateManagementTo());
        addPredicateFk("document","id", criteria.getDocument()==null?null:criteria.getDocument().getId());
        addPredicateFk("document","id", criteria.getDocuments());
        addPredicateFk("document","reference", criteria.getDocument()==null?null:criteria.getDocument().getReference());
        addPredicateFk("utilisateur","id", criteria.getUtilisateur()==null?null:criteria.getUtilisateur().getId());
        addPredicateFk("utilisateur","id", criteria.getUtilisateurs());
        addPredicateFk("utilisateur","email", criteria.getUtilisateur()==null?null:criteria.getUtilisateur().getEmail());
        addPredicateFk("acessManagement","id", criteria.getAcessManagement()==null?null:criteria.getAcessManagement().getId());
        addPredicateFk("acessManagement","id", criteria.getAcessManagements());
        addPredicateFk("acessManagement","code", criteria.getAcessManagement()==null?null:criteria.getAcessManagement().getCode());
    }

    public DocumentManagementUtilisateurSpecification(DocumentManagementUtilisateurCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementUtilisateurSpecification(DocumentManagementUtilisateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
