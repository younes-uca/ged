package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.Document;
import ma.sir.ana.bean.history.DocumentHistory;
import ma.sir.ana.dao.criteria.core.DocumentCriteria;
import ma.sir.ana.dao.criteria.history.DocumentHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentDao;
import ma.sir.ana.dao.facade.history.DocumentHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentSpecification;
import ma.sir.ana.service.facade.admin.DocumentAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ana.bean.core.DocumentField;
import ma.sir.ana.bean.core.DocumentPartageGroupe;
import ma.sir.ana.bean.core.DocumentPartageUtilisateur;
import ma.sir.ana.bean.core.DocumentManagementGroupe;
import ma.sir.ana.bean.core.DocumentManagementUtilisateur;
import ma.sir.ana.bean.core.DocumentAcessShare;
import ma.sir.ana.bean.core.DocumentTag;

import ma.sir.ana.service.facade.admin.DocumentTypeAdminService ;
import ma.sir.ana.service.facade.admin.DocumentManagementGroupeAdminService ;
import ma.sir.ana.service.facade.admin.DocumentStateAdminService ;
import ma.sir.ana.service.facade.admin.UtilisateurAdminService ;
import ma.sir.ana.service.facade.admin.EntiteAdministrativeAdminService ;
import ma.sir.ana.service.facade.admin.DocumentCategorieAdminService ;
import ma.sir.ana.service.facade.admin.DocumentAcessShareAdminService ;
import ma.sir.ana.service.facade.admin.DocumentManagementUtilisateurAdminService ;
import ma.sir.ana.service.facade.admin.DocumentPartageGroupeAdminService ;
import ma.sir.ana.service.facade.admin.DocumentTagAdminService ;
import ma.sir.ana.service.facade.admin.DocumentPartageUtilisateurAdminService ;
import ma.sir.ana.service.facade.admin.DocumentFieldAdminService ;



import java.util.List;
@Service
public class DocumentAdminServiceImpl extends AbstractServiceImpl<Document,DocumentHistory, DocumentCriteria, DocumentHistoryCriteria, DocumentDao,
DocumentHistoryDao> implements DocumentAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Document create(Document t) {
        super.create(t);
        if (t.getDocumentFields() != null) {
                t.getDocumentFields().forEach(element-> {
                    element.setDocument(t);
                    documentFieldService.create(element);
            });
        }
        if (t.getDocumentPartageGroupes() != null) {
                t.getDocumentPartageGroupes().forEach(element-> {
                    element.setDocument(t);
                    documentPartageGroupeService.create(element);
            });
        }
        if (t.getDocumentPartageUtilisateurs() != null) {
                t.getDocumentPartageUtilisateurs().forEach(element-> {
                    element.setDocument(t);
                    documentPartageUtilisateurService.create(element);
            });
        }
        if (t.getDocumentManagementGroupes() != null) {
                t.getDocumentManagementGroupes().forEach(element-> {
                    element.setDocument(t);
                    documentManagementGroupeService.create(element);
            });
        }
        if (t.getDocumentManagementUtilisateurs() != null) {
                t.getDocumentManagementUtilisateurs().forEach(element-> {
                    element.setDocument(t);
                    documentManagementUtilisateurService.create(element);
            });
        }
        if (t.getDocumentAcessShares() != null) {
                t.getDocumentAcessShares().forEach(element-> {
                    element.setDocument(t);
                    documentAcessShareService.create(element);
            });
        }
        if (t.getDocumentTags() != null) {
                t.getDocumentTags().forEach(element-> {
                    element.setDocument(t);
                    documentTagService.create(element);
            });
        }
        return t;
    }

    public Document findWithAssociatedLists(Long id){
        Document result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setDocumentFields(documentFieldService.findByDocumentId(id));
            result.setDocumentPartageGroupes(documentPartageGroupeService.findByDocumentId(id));
            result.setDocumentPartageUtilisateurs(documentPartageUtilisateurService.findByDocumentId(id));
            result.setDocumentManagementGroupes(documentManagementGroupeService.findByDocumentId(id));
            result.setDocumentManagementUtilisateurs(documentManagementUtilisateurService.findByDocumentId(id));
            result.setDocumentAcessShares(documentAcessShareService.findByDocumentId(id));
            result.setDocumentTags(documentTagService.findByDocumentId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        documentFieldService.deleteByDocumentId(id);
        documentPartageGroupeService.deleteByDocumentId(id);
        documentPartageUtilisateurService.deleteByDocumentId(id);
        documentManagementGroupeService.deleteByDocumentId(id);
        documentManagementUtilisateurService.deleteByDocumentId(id);
        documentAcessShareService.deleteByDocumentId(id);
        documentTagService.deleteByDocumentId(id);
    }


    public void updateWithAssociatedLists(Document document){
    if(document !=null && document.getId() != null){
            List<List<DocumentField>> resultDocumentFields= documentFieldService.getToBeSavedAndToBeDeleted(documentFieldService.findByDocumentId(document.getId()),document.getDocumentFields());
            documentFieldService.delete(resultDocumentFields.get(1));
            ListUtil.emptyIfNull(resultDocumentFields.get(0)).forEach(e -> e.setDocument(document));
            documentFieldService.update(resultDocumentFields.get(0),true);
            List<List<DocumentPartageGroupe>> resultDocumentPartageGroupes= documentPartageGroupeService.getToBeSavedAndToBeDeleted(documentPartageGroupeService.findByDocumentId(document.getId()),document.getDocumentPartageGroupes());
            documentPartageGroupeService.delete(resultDocumentPartageGroupes.get(1));
            ListUtil.emptyIfNull(resultDocumentPartageGroupes.get(0)).forEach(e -> e.setDocument(document));
            documentPartageGroupeService.update(resultDocumentPartageGroupes.get(0),true);
            List<List<DocumentPartageUtilisateur>> resultDocumentPartageUtilisateurs= documentPartageUtilisateurService.getToBeSavedAndToBeDeleted(documentPartageUtilisateurService.findByDocumentId(document.getId()),document.getDocumentPartageUtilisateurs());
            documentPartageUtilisateurService.delete(resultDocumentPartageUtilisateurs.get(1));
            ListUtil.emptyIfNull(resultDocumentPartageUtilisateurs.get(0)).forEach(e -> e.setDocument(document));
            documentPartageUtilisateurService.update(resultDocumentPartageUtilisateurs.get(0),true);
            List<List<DocumentManagementGroupe>> resultDocumentManagementGroupes= documentManagementGroupeService.getToBeSavedAndToBeDeleted(documentManagementGroupeService.findByDocumentId(document.getId()),document.getDocumentManagementGroupes());
            documentManagementGroupeService.delete(resultDocumentManagementGroupes.get(1));
            ListUtil.emptyIfNull(resultDocumentManagementGroupes.get(0)).forEach(e -> e.setDocument(document));
            documentManagementGroupeService.update(resultDocumentManagementGroupes.get(0),true);
            List<List<DocumentManagementUtilisateur>> resultDocumentManagementUtilisateurs= documentManagementUtilisateurService.getToBeSavedAndToBeDeleted(documentManagementUtilisateurService.findByDocumentId(document.getId()),document.getDocumentManagementUtilisateurs());
            documentManagementUtilisateurService.delete(resultDocumentManagementUtilisateurs.get(1));
            ListUtil.emptyIfNull(resultDocumentManagementUtilisateurs.get(0)).forEach(e -> e.setDocument(document));
            documentManagementUtilisateurService.update(resultDocumentManagementUtilisateurs.get(0),true);
            List<List<DocumentAcessShare>> resultDocumentAcessShares= documentAcessShareService.getToBeSavedAndToBeDeleted(documentAcessShareService.findByDocumentId(document.getId()),document.getDocumentAcessShares());
            documentAcessShareService.delete(resultDocumentAcessShares.get(1));
            ListUtil.emptyIfNull(resultDocumentAcessShares.get(0)).forEach(e -> e.setDocument(document));
            documentAcessShareService.update(resultDocumentAcessShares.get(0),true);
            List<List<DocumentTag>> resultDocumentTags= documentTagService.getToBeSavedAndToBeDeleted(documentTagService.findByDocumentId(document.getId()),document.getDocumentTags());
            documentTagService.delete(resultDocumentTags.get(1));
            ListUtil.emptyIfNull(resultDocumentTags.get(0)).forEach(e -> e.setDocument(document));
            documentTagService.update(resultDocumentTags.get(0),true);
    }
    }

    public Document findByReferenceEntity(Document t){
        return  dao.findByReference(t.getReference());
    }

    public List<Document> findByDocumentTypeId(Long id){
        return dao.findByDocumentTypeId(id);
    }
    public int deleteByDocumentTypeId(Long id){
        return dao.deleteByDocumentTypeId(id);
    }
    public List<Document> findByDocumentStateId(Long id){
        return dao.findByDocumentStateId(id);
    }
    public int deleteByDocumentStateId(Long id){
        return dao.deleteByDocumentStateId(id);
    }
    public List<Document> findByDocumentCategorieId(Long id){
        return dao.findByDocumentCategorieId(id);
    }
    public int deleteByDocumentCategorieId(Long id){
        return dao.deleteByDocumentCategorieId(id);
    }
    public List<Document> findByUtilisateurId(Long id){
        return dao.findByUtilisateurId(id);
    }
    public int deleteByUtilisateurId(Long id){
        return dao.deleteByUtilisateurId(id);
    }
    public List<Document> findByEntiteAdministrativeId(Long id){
        return dao.findByEntiteAdministrativeId(id);
    }
    public int deleteByEntiteAdministrativeId(Long id){
        return dao.deleteByEntiteAdministrativeId(id);
    }




    public void configure() {
        super.configure(Document.class,DocumentHistory.class, DocumentHistoryCriteria.class, DocumentSpecification.class);
    }

    @Autowired
    private DocumentTypeAdminService documentTypeService ;
    @Autowired
    private DocumentManagementGroupeAdminService documentManagementGroupeService ;
    @Autowired
    private DocumentStateAdminService documentStateService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;
    @Autowired
    private EntiteAdministrativeAdminService entiteAdministrativeService ;
    @Autowired
    private DocumentCategorieAdminService documentCategorieService ;
    @Autowired
    private DocumentAcessShareAdminService documentAcessShareService ;
    @Autowired
    private DocumentManagementUtilisateurAdminService documentManagementUtilisateurService ;
    @Autowired
    private DocumentPartageGroupeAdminService documentPartageGroupeService ;
    @Autowired
    private DocumentTagAdminService documentTagService ;
    @Autowired
    private DocumentPartageUtilisateurAdminService documentPartageUtilisateurService ;
    @Autowired
    private DocumentFieldAdminService documentFieldService ;

    public DocumentAdminServiceImpl(DocumentDao dao, DocumentHistoryDao historyDao) {
        super(dao, historyDao);
    }

}