import axios, { AxiosResponse } from "axios";
import { API_URL } from '../../../layout/AppConfig';
import {PaginatedList} from '../../zynerator/dto/PaginatedList.model';
import {AcessManagementDto} from '../../controller/model/AcessManagement.model';
import {AcessManagementCriteria} from '../../controller/criteria/AcessManagementCriteria.model';



export const AcessManagementService = {

   getList(): Promise<AxiosResponse<AcessManagementDto[]>> {
     return axios.get(API_URL + 'acessManagement/');
   },

   save(item: AcessManagementDto): Promise<AxiosResponse<AcessManagementDto>> {
     return axios.post(API_URL + 'acessManagement/', item);
   },

   update(item: AcessManagementDto): Promise<AxiosResponse<AcessManagementDto>> {
      return axios.put(API_URL + 'acessManagement/', item);
   },

   delete(id: number): Promise<AxiosResponse<AcessManagementDto>> {
      return axios.delete(API_URL + 'acessManagement/id/'+ id);
   },

   deleteList(items: AcessManagementDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'acessManagement/multiple', items);
   },

   findPaginatedByCriteria(criteria:AcessManagementCriteria):Promise<AxiosResponse<PaginatedList<AcessManagementDto>>> {
     return axios.post<PaginatedList<AcessManagementDto>>(API_URL + 'acessManagement/find-paginated-by-criteria', criteria);
   }
};

