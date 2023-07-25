import axios, { AxiosResponse } from "axios";
import { API_URL } from '../../../layout/AppConfig';
import {PaginatedList} from '../../zynerator/dto/PaginatedList.model';
import {DocumentManagementUtilisateurDto} from '../../controller/model/DocumentManagementUtilisateur.model';
import {DocumentManagementUtilisateurCriteria} from '../../controller/criteria/DocumentManagementUtilisateurCriteria.model';



export const DocumentManagementUtilisateurService = {

   getList(): Promise<AxiosResponse<DocumentManagementUtilisateurDto[]>> {
     return axios.get(API_URL + 'documentManagementUtilisateur/');
   },

   save(item: DocumentManagementUtilisateurDto): Promise<AxiosResponse<DocumentManagementUtilisateurDto>> {
     return axios.post(API_URL + 'documentManagementUtilisateur/', item);
   },

   update(item: DocumentManagementUtilisateurDto): Promise<AxiosResponse<DocumentManagementUtilisateurDto>> {
      return axios.put(API_URL + 'documentManagementUtilisateur/', item);
   },

   delete(id: number): Promise<AxiosResponse<DocumentManagementUtilisateurDto>> {
      return axios.delete(API_URL + 'documentManagementUtilisateur/id/'+ id);
   },

   deleteList(items: DocumentManagementUtilisateurDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'documentManagementUtilisateur/multiple', items);
   },

   findPaginatedByCriteria(criteria:DocumentManagementUtilisateurCriteria):Promise<AxiosResponse<PaginatedList<DocumentManagementUtilisateurDto>>> {
     return axios.post<PaginatedList<DocumentManagementUtilisateurDto>>(API_URL + 'documentManagementUtilisateur/find-paginated-by-criteria', criteria);
   }
};

