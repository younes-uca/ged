import {ADMIN_URL} from 'layout/AppConfig';
import {DocumentDto} from 'app/controller/model/Document.model';
import AbstractService from "../../../zynerator/service/AbstractService";
import {DocumentCriteria} from "../../criteria/DocumentCriteria.model";


export class DocumentAdminService extends AbstractService<DocumentDto,DocumentCriteria> {

    constructor() {
        super(ADMIN_URL, 'document/');
    }
};

