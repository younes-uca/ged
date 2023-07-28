import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {ClientCategoryDto} from 'app/controller/model/ClientCategory.model';
import {ClientCategoryCriteria} from 'app/controller/criteria/ClientCategoryCriteria.model';



export const ClientCategoryService = {

   getList(): Promise<AxiosResponse<ClientCategoryDto[]>> {
     return axios.get(ADMIN_URL + 'clientCategory/');
   },

   save(item: ClientCategoryDto): Promise<AxiosResponse<ClientCategoryDto>> {
     return axios.post(ADMIN_URL + 'clientCategory/', item);
   },

   update(item: ClientCategoryDto): Promise<AxiosResponse<ClientCategoryDto>> {
      return axios.put(ADMIN_URL + 'clientCategory/', item);
   },

   delete(id: number): Promise<AxiosResponse<ClientCategoryDto>> {
      return axios.delete(ADMIN_URL + 'clientCategory/id/'+ id);
   },

   deleteList(items: ClientCategoryDto[]): Promise<AxiosResponse<string>> {
      return axios.post(ADMIN_URL + 'clientCategory/multiple', items);
   },

   findPaginatedByCriteria(criteria:ClientCategoryCriteria):Promise<AxiosResponse<PaginatedList<ClientCategoryDto>>> {
     return axios.post<PaginatedList<ClientCategoryDto>>(ADMIN_URL + 'clientCategory/find-paginated-by-criteria', criteria);
   }
};

