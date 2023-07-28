import axios, { AxiosResponse } from "axios";
import { AGENT_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {ClientDto} from 'app/controller/model/Client.model';
import {ClientCriteria} from 'app/controller/criteria/ClientCriteria.model';



export const ClientAgentService = {

   getList(): Promise<AxiosResponse<ClientDto[]>> {
     return axios.get(AGENT_URL + 'client/');
   },

   save(item: ClientDto): Promise<AxiosResponse<ClientDto>> {
     return axios.post(AGENT_URL + 'client/', item);
   },

   update(item: ClientDto): Promise<AxiosResponse<ClientDto>> {
      return axios.put(AGENT_URL + 'client/', item);
   },

   delete(id: number): Promise<AxiosResponse<ClientDto>> {
      return axios.delete(AGENT_URL + 'client/id/'+ id);
   },

   deleteList(items: ClientDto[]): Promise<AxiosResponse<string>> {
      return axios.post(AGENT_URL + 'client/multiple', items);
   },

   findPaginatedByCriteria(criteria:ClientCriteria):Promise<AxiosResponse<PaginatedList<ClientDto>>> {
     return axios.post<PaginatedList<ClientDto>>(AGENT_URL + 'client/find-paginated-by-criteria', criteria);
   }
};

