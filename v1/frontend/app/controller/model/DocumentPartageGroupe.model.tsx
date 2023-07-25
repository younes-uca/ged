import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {AcessShareDto} from '../../controller/model/AcessShare.model';
import {GroupeDto} from '../../controller/model/Groupe.model';
import {DocumentDto} from '../../controller/model/Document.model';

export class DocumentPartageGroupeDto extends BaseDto{



   public dateShare: Date;
    public dateShareMax: string ;
    public dateShareMin: string ;
    public document: DocumentDto ;
    public groupe: GroupeDto ;
    public acessShare: AcessShareDto ;

}
