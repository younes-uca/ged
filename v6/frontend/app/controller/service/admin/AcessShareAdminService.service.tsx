import axios, { AxiosResponse } from "axios";
import { ADMIN_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {AcessShareDto} from 'app/controller/model/AcessShare.model';
import {AcessShareCriteria} from 'app/controller/criteria/AcessShareCriteria.model';



export const AcessShareAdminService = {

   getList(): Promise<AxiosResponse<AcessShareDto[]>> {
     return axios.get(ADMIN_URL + 'acessShare/');
   },

   save(item: AcessShareDto): Promise<AxiosResponse<AcessShareDto>> {
     return axios.post(ADMIN_URL + 'acessShare/', item);
   },

   update(item: AcessShareDto): Promise<AxiosResponse<AcessShareDto>> {
      return axios.put(ADMIN_URL + 'acessShare/', item);
   },

   delete(id: number): Promise<AxiosResponse<AcessShareDto>> {
      return axios.delete(ADMIN_URL + 'acessShare/id/'+ id);
   },

   deleteList(items: AcessShareDto[]): Promise<AxiosResponse<string>> {
      return axios.post(ADMIN_URL + 'acessShare/multiple', items);
   },

   findPaginatedByCriteria(criteria:AcessShareCriteria):Promise<AxiosResponse<PaginatedList<AcessShareDto>>> {
     return axios.post<PaginatedList<AcessShareDto>>(ADMIN_URL + 'acessShare/find-paginated-by-criteria', criteria);
   }
};

