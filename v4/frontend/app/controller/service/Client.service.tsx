import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {ClientDto} from 'app/controller/model/Client.model';
import {ClientCriteria} from 'app/controller/criteria/ClientCriteria.model';



export const ClientService = {

   getList(): Promise<AxiosResponse<ClientDto[]>> {
     return axios.get(API_URL + 'client/');
   },

   save(item: ClientDto): Promise<AxiosResponse<ClientDto>> {
     return axios.post(API_URL + 'client/', item);
   },

   update(item: ClientDto): Promise<AxiosResponse<ClientDto>> {
      return axios.put(API_URL + 'client/', item);
   },

   delete(id: number): Promise<AxiosResponse<ClientDto>> {
      return axios.delete(API_URL + 'client/id/'+ id);
   },

   deleteList(items: ClientDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'client/multiple', items);
   },

   findPaginatedByCriteria(criteria:ClientCriteria):Promise<AxiosResponse<PaginatedList<ClientDto>>> {
     return axios.post<PaginatedList<ClientDto>>(API_URL + 'client/find-paginated-by-criteria', criteria);
   }
};

