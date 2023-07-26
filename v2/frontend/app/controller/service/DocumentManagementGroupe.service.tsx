import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {DocumentManagementGroupeDto} from 'app/controller/model/DocumentManagementGroupe.model';
import {DocumentManagementGroupeCriteria} from 'app/controller/criteria/DocumentManagementGroupeCriteria.model';



export const DocumentManagementGroupeService = {

   getList(): Promise<AxiosResponse<DocumentManagementGroupeDto[]>> {
     return axios.get(API_URL + 'documentManagementGroupe/');
   },

   save(item: DocumentManagementGroupeDto): Promise<AxiosResponse<DocumentManagementGroupeDto>> {
     return axios.post(API_URL + 'documentManagementGroupe/', item);
   },

   update(item: DocumentManagementGroupeDto): Promise<AxiosResponse<DocumentManagementGroupeDto>> {
      return axios.put(API_URL + 'documentManagementGroupe/', item);
   },

   delete(id: number): Promise<AxiosResponse<DocumentManagementGroupeDto>> {
      return axios.delete(API_URL + 'documentManagementGroupe/id/'+ id);
   },

   deleteList(items: DocumentManagementGroupeDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'documentManagementGroupe/multiple', items);
   },

   findPaginatedByCriteria(criteria:DocumentManagementGroupeCriteria):Promise<AxiosResponse<PaginatedList<DocumentManagementGroupeDto>>> {
     return axios.post<PaginatedList<DocumentManagementGroupeDto>>(API_URL + 'documentManagementGroupe/find-paginated-by-criteria', criteria);
   }
};

