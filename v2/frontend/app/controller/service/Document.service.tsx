import axios, { AxiosResponse } from "axios";
import { API_URL } from '../../../layout/AppConfig';
import {PaginatedList} from '../../zynerator/dto/PaginatedList.model';
import {DocumentDto} from '../../controller/model/Document.model';
import {DocumentCriteria} from '../../controller/criteria/DocumentCriteria.model';



export const DocumentService = {

   getList(): Promise<AxiosResponse<DocumentDto[]>> {
     return axios.get(API_URL + 'document/');
   },

   save(item: DocumentDto): Promise<AxiosResponse<DocumentDto>> {
     return axios.post(API_URL + 'document/', item);
   },

   update(item: DocumentDto): Promise<AxiosResponse<DocumentDto>> {
      return axios.put(API_URL + 'document/', item);
   },

   delete(id: number): Promise<AxiosResponse<DocumentDto>> {
      return axios.delete(API_URL + 'document/id/'+ id);
   },

   deleteList(items: DocumentDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'document/multiple', items);
   },

   findPaginatedByCriteria(criteria:DocumentCriteria):Promise<AxiosResponse<PaginatedList<DocumentDto>>> {
     return axios.post<PaginatedList<DocumentDto>>(API_URL + 'document/find-paginated-by-criteria', criteria);
   }
};

