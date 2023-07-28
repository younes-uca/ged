import axios, { AxiosResponse } from "axios";
import {ADMIN_URL} from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {AcessManagementDto} from 'app/controller/model/AcessManagement.model';
import {AcessManagementCriteria} from 'app/controller/criteria/AcessManagementCriteria.model';



export const AcessManagementService = {

   getList(): Promise<AxiosResponse<AcessManagementDto[]>> {
     return axios.get(ADMIN_URL + 'acessManagement/');
   },

   save(item: AcessManagementDto): Promise<AxiosResponse<AcessManagementDto>> {
     return axios.post(ADMIN_URL + 'acessManagement/', item);
   },

   update(item: AcessManagementDto): Promise<AxiosResponse<AcessManagementDto>> {
      return axios.put(ADMIN_URL + 'acessManagement/', item);
   },

   delete(id: number): Promise<AxiosResponse<AcessManagementDto>> {
      return axios.delete(ADMIN_URL + 'acessManagement/id/'+ id);
   },

   deleteList(items: AcessManagementDto[]): Promise<AxiosResponse<string>> {
      return axios.post(ADMIN_URL + 'acessManagement/multiple', items);
   },

   findPaginatedByCriteria(criteria:AcessManagementCriteria):Promise<AxiosResponse<PaginatedList<AcessManagementDto>>> {
     return axios.post<PaginatedList<AcessManagementDto>>(ADMIN_URL + 'acessManagement/find-paginated-by-criteria', criteria);
   }
};

