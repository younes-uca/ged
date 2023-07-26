import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {DocumentAcessShareDto} from 'app/controller/model/DocumentAcessShare.model';
import {DocumentAcessShareCriteria} from 'app/controller/criteria/DocumentAcessShareCriteria.model';



export const DocumentAcessShareService = {

   getList(): Promise<AxiosResponse<DocumentAcessShareDto[]>> {
     return axios.get(API_URL + 'documentAcessShare/');
   },

   save(item: DocumentAcessShareDto): Promise<AxiosResponse<DocumentAcessShareDto>> {
     return axios.post(API_URL + 'documentAcessShare/', item);
   },

   update(item: DocumentAcessShareDto): Promise<AxiosResponse<DocumentAcessShareDto>> {
      return axios.put(API_URL + 'documentAcessShare/', item);
   },

   delete(id: number): Promise<AxiosResponse<DocumentAcessShareDto>> {
      return axios.delete(API_URL + 'documentAcessShare/id/'+ id);
   },

   deleteList(items: DocumentAcessShareDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'documentAcessShare/multiple', items);
   },

   findPaginatedByCriteria(criteria:DocumentAcessShareCriteria):Promise<AxiosResponse<PaginatedList<DocumentAcessShareDto>>> {
     return axios.post<PaginatedList<DocumentAcessShareDto>>(API_URL + 'documentAcessShare/find-paginated-by-criteria', criteria);
   }
};

