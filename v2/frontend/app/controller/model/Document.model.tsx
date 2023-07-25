import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {DocumentPartageGroupeDto} from '../../controller/model/DocumentPartageGroupe.model';
import {DocumentTagDto} from '../../controller/model/DocumentTag.model';
import {DocumentPartageUtilisateurDto} from '../../controller/model/DocumentPartageUtilisateur.model';
import {DocumentTypeDto} from '../../controller/model/DocumentType.model';
import {EntiteAdministrativeDto} from '../../controller/model/EntiteAdministrative.model';
import {DocumentManagementGroupeDto} from '../../controller/model/DocumentManagementGroupe.model';
import {DocumentAcessShareDto} from '../../controller/model/DocumentAcessShare.model';
import {UtilisateurDto} from '../../controller/model/Utilisateur.model';
import {DocumentManagementUtilisateurDto} from '../../controller/model/DocumentManagementUtilisateur.model';

export class DocumentDto extends BaseDto{

    public reference: string;

   public uploadDate: Date;

   public dateLastUpdate: Date;

    public content: string;

    public size: number;

    public description: string;

   public archive: null | boolean;

   public versionne: null | boolean;

    public documentType: DocumentTypeDto ;
    public utilisateur: UtilisateurDto ;
    public entiteAdministrative: EntiteAdministrativeDto ;
     public documentPartageGroupes: Array<DocumentPartageGroupeDto>;
     public documentPartageUtilisateurs: Array<DocumentPartageUtilisateurDto>;
     public documentManagementGroupes: Array<DocumentManagementGroupeDto>;
     public documentManagementUtilisateurs: Array<DocumentManagementUtilisateurDto>;
     public documentAcessShares: Array<DocumentAcessShareDto>;
     public documentTags: Array<DocumentTagDto>;


    constructor() {
    super();

        reference = '';
        uploadDate = null;
        dateLastUpdate = null;
        content = '';
        size = 0;
        description = '';
        archive = null;
        versionne = null;
        documentType = new DocumentTypeDto() ;
        utilisateur = new UtilisateurDto() ;
        entiteAdministrative = new EntiteAdministrativeDto() ;
        documentPartageGroupes = new Array<DocumentPartageGroupeDto>();
        documentPartageUtilisateurs = new Array<DocumentPartageUtilisateurDto>();
        documentManagementGroupes = new Array<DocumentManagementGroupeDto>();
        documentManagementUtilisateurs = new Array<DocumentManagementUtilisateurDto>();
        documentAcessShares = new Array<DocumentAcessShareDto>();
        documentTags = new Array<DocumentTagDto>();

        }

}
