import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {DocumentPartageGroupeDto} from 'app/controller/model/DocumentPartageGroupe.model';
import {DocumentPartageGroupeCriteria} from 'app/controller/criteria/DocumentPartageGroupeCriteria.model';



export const DocumentPartageGroupeService = {

   getList(): Promise<AxiosResponse<DocumentPartageGroupeDto[]>> {
     return axios.get(API_URL + 'documentPartageGroupe/');
   },

   save(item: DocumentPartageGroupeDto): Promise<AxiosResponse<DocumentPartageGroupeDto>> {
     return axios.post(API_URL + 'documentPartageGroupe/', item);
   },

   update(item: DocumentPartageGroupeDto): Promise<AxiosResponse<DocumentPartageGroupeDto>> {
      return axios.put(API_URL + 'documentPartageGroupe/', item);
   },

   delete(id: number): Promise<AxiosResponse<DocumentPartageGroupeDto>> {
      return axios.delete(API_URL + 'documentPartageGroupe/id/'+ id);
   },

   deleteList(items: DocumentPartageGroupeDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'documentPartageGroupe/multiple', items);
   },

   findPaginatedByCriteria(criteria:DocumentPartageGroupeCriteria):Promise<AxiosResponse<PaginatedList<DocumentPartageGroupeDto>>> {
     return axios.post<PaginatedList<DocumentPartageGroupeDto>>(API_URL + 'documentPartageGroupe/find-paginated-by-criteria', criteria);
   }
};

