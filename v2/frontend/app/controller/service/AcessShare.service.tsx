import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {AcessShareDto} from 'app/controller/model/AcessShare.model';
import {AcessShareCriteria} from 'app/controller/criteria/AcessShareCriteria.model';



export const AcessShareService = {

   getList(): Promise<AxiosResponse<AcessShareDto[]>> {
     return axios.get(API_URL + 'acessShare/');
   },

   save(item: AcessShareDto): Promise<AxiosResponse<AcessShareDto>> {
     return axios.post(API_URL + 'acessShare/', item);
   },

   update(item: AcessShareDto): Promise<AxiosResponse<AcessShareDto>> {
      return axios.put(API_URL + 'acessShare/', item);
   },

   delete(id: number): Promise<AxiosResponse<AcessShareDto>> {
      return axios.delete(API_URL + 'acessShare/id/'+ id);
   },

   deleteList(items: AcessShareDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'acessShare/multiple', items);
   },

   findPaginatedByCriteria(criteria:AcessShareCriteria):Promise<AxiosResponse<PaginatedList<AcessShareDto>>> {
     return axios.post<PaginatedList<AcessShareDto>>(API_URL + 'acessShare/find-paginated-by-criteria', criteria);
   }
};

