import { ADMIN_URL } from 'layout/AppConfig';
import AbstractService from "app/zynerator/service/AbstractService";

import {DocumentIndexElementStateDto} from 'app/controller/model/DocumentIndexElementState.model';
import {DocumentIndexElementStateCriteria} from 'app/controller/criteria/DocumentIndexElementStateCriteria.model';

export class DocumentIndexElementStateAdminService extends AbstractService<DocumentIndexElementStateDto, DocumentIndexElementStateCriteria>{

    constructor() {
        super(ADMIN_URL , 'documentIndexElementState/');
    }

};