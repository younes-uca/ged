import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {DocumentPartageGroupeCriteria} from './DocumentPartageGroupeCriteria.model';
import {DocumentTagCriteria} from './DocumentTagCriteria.model';
import {DocumentPartageUtilisateurCriteria} from './DocumentPartageUtilisateurCriteria.model';
import {DocumentTypeCriteria} from './DocumentTypeCriteria.model';
import {EntiteAdministrativeCriteria} from './EntiteAdministrativeCriteria.model';
import {DocumentManagementGroupeCriteria} from './DocumentManagementGroupeCriteria.model';
import {DocumentAcessShareCriteria} from './DocumentAcessShareCriteria.model';
import {UtilisateurCriteria} from './UtilisateurCriteria.model';
import {DocumentManagementUtilisateurCriteria} from './DocumentManagementUtilisateurCriteria.model';




export class DocumentCriteria  extends  BaseCriteria {

    public id: number;

    public reference: string;
    public referenceLike: string;
    public uploadDate: Date;
    public uploadDateFrom: Date;
    public uploadDateTo: Date;
    public dateLastUpdate: Date;
    public dateLastUpdateFrom: Date;
    public dateLastUpdateTo: Date;
    public content: string;
    public contentLike: string;
     public size: null | number;
     public sizeMin: null | number;
     public sizeMax: null | number;
    public description: string;
    public descriptionLike: string;
    public archive: null | boolean;
    public versionne: null | boolean;
  public documentType: DocumentTypeCriteria ;
  public documentTypes: Array<DocumentTypeCriteria> ;
  public utilisateur: UtilisateurCriteria ;
  public utilisateurs: Array<UtilisateurCriteria> ;
  public entiteAdministrative: EntiteAdministrativeCriteria ;
  public entiteAdministratives: Array<EntiteAdministrativeCriteria> ;
      public documentPartageGroupes: Array<DocumentPartageGroupeCriteria>;
      public documentPartageUtilisateurs: Array<DocumentPartageUtilisateurCriteria>;
      public documentManagementGroupes: Array<DocumentManagementGroupeCriteria>;
      public documentManagementUtilisateurs: Array<DocumentManagementUtilisateurCriteria>;
      public documentAcessShares: Array<DocumentAcessShareCriteria>;
      public documentTags: Array<DocumentTagCriteria>;

    constructor() {
        super();
        this.reference = '';
        this.referenceLike = '';
        this.uploadDate = null;
        this.uploadDateFrom  = null;
        this.uploadDateTo = null;
        this.dateLastUpdate = null;
        this.dateLastUpdateFrom  = null;
        this.dateLastUpdateTo = null;
        this.content = '';
        this.contentLike = '';
        this.size = null;
        this.sizeMin = null;
        this.sizeMax = null;
        this.description = '';
        this.descriptionLike = '';
        this.archive = null;
        this.versionne = null;
        this.documentType = new DocumentTypeCriteria() ;
        this.documentTypes = new Array<DocumentTypeCriteria>() ;
        this.utilisateur = new UtilisateurCriteria() ;
        this.utilisateurs = new Array<UtilisateurCriteria>() ;
        this.entiteAdministrative = new EntiteAdministrativeCriteria() ;
        this.entiteAdministratives = new Array<EntiteAdministrativeCriteria>() ;
    }

}
