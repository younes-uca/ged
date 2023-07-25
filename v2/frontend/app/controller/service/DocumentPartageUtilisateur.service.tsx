import axios, { AxiosResponse } from "axios";
import { API_URL } from '../../../layout/AppConfig';
import {PaginatedList} from '../../zynerator/dto/PaginatedList.model';
import {DocumentPartageUtilisateurDto} from '../../controller/model/DocumentPartageUtilisateur.model';
import {DocumentPartageUtilisateurCriteria} from '../../controller/criteria/DocumentPartageUtilisateurCriteria.model';



export const DocumentPartageUtilisateurService = {

   getList(): Promise<AxiosResponse<DocumentPartageUtilisateurDto[]>> {
     return axios.get(API_URL + 'documentPartageUtilisateur/');
   },

   save(item: DocumentPartageUtilisateurDto): Promise<AxiosResponse<DocumentPartageUtilisateurDto>> {
     return axios.post(API_URL + 'documentPartageUtilisateur/', item);
   },

   update(item: DocumentPartageUtilisateurDto): Promise<AxiosResponse<DocumentPartageUtilisateurDto>> {
      return axios.put(API_URL + 'documentPartageUtilisateur/', item);
   },

   delete(id: number): Promise<AxiosResponse<DocumentPartageUtilisateurDto>> {
      return axios.delete(API_URL + 'documentPartageUtilisateur/id/'+ id);
   },

   deleteList(items: DocumentPartageUtilisateurDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'documentPartageUtilisateur/multiple', items);
   },

   findPaginatedByCriteria(criteria:DocumentPartageUtilisateurCriteria):Promise<AxiosResponse<PaginatedList<DocumentPartageUtilisateurDto>>> {
     return axios.post<PaginatedList<DocumentPartageUtilisateurDto>>(API_URL + 'documentPartageUtilisateur/find-paginated-by-criteria', criteria);
   }
};

