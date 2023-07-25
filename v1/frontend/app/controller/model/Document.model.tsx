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
    public uploadDateMax: string ;
    public uploadDateMin: string ;
    public dateLastUpdateMax: string ;
    public dateLastUpdateMin: string ;
    public sizeMax: string ;
    public sizeMin: string ;
    public documentType: DocumentTypeDto ;
    public utilisateur: UtilisateurDto ;
    public entiteAdministrative: EntiteAdministrativeDto ;
     public documentPartageGroupes: Array<DocumentPartageGroupeDto>;
     public documentPartageUtilisateurs: Array<DocumentPartageUtilisateurDto>;
     public documentManagementGroupes: Array<DocumentManagementGroupeDto>;
     public documentManagementUtilisateurs: Array<DocumentManagementUtilisateurDto>;
     public documentAcessShares: Array<DocumentAcessShareDto>;
     public documentTags: Array<DocumentTagDto>;

}
