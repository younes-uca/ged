import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {PurchaseTagDto} from 'app/controller/model/PurchaseTag.model';
import {PurchaseTagCriteria} from 'app/controller/criteria/PurchaseTagCriteria.model';



export const PurchaseTagService = {

   getList(): Promise<AxiosResponse<PurchaseTagDto[]>> {
     return axios.get(ADMIN_URL + 'purchaseTag/');
   },

   save(item: PurchaseTagDto): Promise<AxiosResponse<PurchaseTagDto>> {
     return axios.post(ADMIN_URL + 'purchaseTag/', item);
   },

   update(item: PurchaseTagDto): Promise<AxiosResponse<PurchaseTagDto>> {
      return axios.put(ADMIN_URL + 'purchaseTag/', item);
   },

   delete(id: number): Promise<AxiosResponse<PurchaseTagDto>> {
      return axios.delete(ADMIN_URL + 'purchaseTag/id/'+ id);
   },

   deleteList(items: PurchaseTagDto[]): Promise<AxiosResponse<string>> {
      return axios.post(ADMIN_URL + 'purchaseTag/multiple', items);
   },

   findPaginatedByCriteria(criteria:PurchaseTagCriteria):Promise<AxiosResponse<PaginatedList<PurchaseTagDto>>> {
     return axios.post<PaginatedList<PurchaseTagDto>>(ADMIN_URL + 'purchaseTag/find-paginated-by-criteria', criteria);
   }
};

