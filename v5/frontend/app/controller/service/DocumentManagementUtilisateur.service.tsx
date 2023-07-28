import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {DocumentManagementUtilisateurDto} from 'app/controller/model/DocumentManagementUtilisateur.model';
import {DocumentManagementUtilisateurCriteria} from 'app/controller/criteria/DocumentManagementUtilisateurCriteria.model';



export const DocumentManagementUtilisateurService = {

   getList(): Promise<AxiosResponse<DocumentManagementUtilisateurDto[]>> {
     return axios.get(ADMIN_URL + 'documentManagementUtilisateur/');
   },

   save(item: DocumentManagementUtilisateurDto): Promise<AxiosResponse<DocumentManagementUtilisateurDto>> {
     return axios.post(ADMIN_URL + 'documentManagementUtilisateur/', item);
   },

   update(item: DocumentManagementUtilisateurDto): Promise<AxiosResponse<DocumentManagementUtilisateurDto>> {
      return axios.put(ADMIN_URL + 'documentManagementUtilisateur/', item);
   },

   delete(id: number): Promise<AxiosResponse<DocumentManagementUtilisateurDto>> {
      return axios.delete(ADMIN_URL + 'documentManagementUtilisateur/id/'+ id);
   },

   deleteList(items: DocumentManagementUtilisateurDto[]): Promise<AxiosResponse<string>> {
      return axios.post(ADMIN_URL + 'documentManagementUtilisateur/multiple', items);
   },

   findPaginatedByCriteria(criteria:DocumentManagementUtilisateurCriteria):Promise<AxiosResponse<PaginatedList<DocumentManagementUtilisateurDto>>> {
     return axios.post<PaginatedList<DocumentManagementUtilisateurDto>>(ADMIN_URL + 'documentManagementUtilisateur/find-paginated-by-criteria', criteria);
   }
};

