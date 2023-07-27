import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {DocumentTypeDto} from 'app/controller/model/DocumentType.model';
import {DocumentTypeCriteria} from 'app/controller/criteria/DocumentTypeCriteria.model';



export const DocumentTypeService = {

   getList(): Promise<AxiosResponse<DocumentTypeDto[]>> {
     return axios.get(API_URL + 'documentType/');
   },

   save(item: DocumentTypeDto): Promise<AxiosResponse<DocumentTypeDto>> {
     return axios.post(API_URL + 'documentType/', item);
   },

   update(item: DocumentTypeDto): Promise<AxiosResponse<DocumentTypeDto>> {
      return axios.put(API_URL + 'documentType/', item);
   },

   delete(id: number): Promise<AxiosResponse<DocumentTypeDto>> {
      return axios.delete(API_URL + 'documentType/id/'+ id);
   },

   deleteList(items: DocumentTypeDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'documentType/multiple', items);
   },

   findPaginatedByCriteria(criteria:DocumentTypeCriteria):Promise<AxiosResponse<PaginatedList<DocumentTypeDto>>> {
     return axios.post<PaginatedList<DocumentTypeDto>>(API_URL + 'documentType/find-paginated-by-criteria', criteria);
   }
};

