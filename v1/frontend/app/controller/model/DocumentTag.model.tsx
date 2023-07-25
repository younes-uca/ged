import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {TagDto} from '../../controller/model/Tag.model';
import {DocumentDto} from '../../controller/model/Document.model';

export class DocumentTagDto extends BaseDto{



    public document: DocumentDto ;
    public tag: TagDto ;

}
