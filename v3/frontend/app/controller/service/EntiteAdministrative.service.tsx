import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {EntiteAdministrativeDto} from 'app/controller/model/EntiteAdministrative.model';
import {EntiteAdministrativeCriteria} from 'app/controller/criteria/EntiteAdministrativeCriteria.model';



export const EntiteAdministrativeService = {

   getList(): Promise<AxiosResponse<EntiteAdministrativeDto[]>> {
     return axios.get(API_URL + 'entiteAdministrative/');
   },

   save(item: EntiteAdministrativeDto): Promise<AxiosResponse<EntiteAdministrativeDto>> {
     return axios.post(API_URL + 'entiteAdministrative/', item);
   },

   update(item: EntiteAdministrativeDto): Promise<AxiosResponse<EntiteAdministrativeDto>> {
      return axios.put(API_URL + 'entiteAdministrative/', item);
   },

   delete(id: number): Promise<AxiosResponse<EntiteAdministrativeDto>> {
      return axios.delete(API_URL + 'entiteAdministrative/id/'+ id);
   },

   deleteList(items: EntiteAdministrativeDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'entiteAdministrative/multiple', items);
   },

   findPaginatedByCriteria(criteria:EntiteAdministrativeCriteria):Promise<AxiosResponse<PaginatedList<EntiteAdministrativeDto>>> {
     return axios.post<PaginatedList<EntiteAdministrativeDto>>(API_URL + 'entiteAdministrative/find-paginated-by-criteria', criteria);
   }
};

