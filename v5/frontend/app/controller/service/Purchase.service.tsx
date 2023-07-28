import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {PurchaseDto} from 'app/controller/model/Purchase.model';
import {PurchaseCriteria} from 'app/controller/criteria/PurchaseCriteria.model';



export const PurchaseService = {

   getList(): Promise<AxiosResponse<PurchaseDto[]>> {
     return axios.get(ADMIN_URL + 'purchase/');
   },

   save(item: PurchaseDto): Promise<AxiosResponse<PurchaseDto>> {
     return axios.post(ADMIN_URL + 'purchase/', item);
   },

   update(item: PurchaseDto): Promise<AxiosResponse<PurchaseDto>> {
      return axios.put(ADMIN_URL + 'purchase/', item);
   },

   delete(id: number): Promise<AxiosResponse<PurchaseDto>> {
      return axios.delete(ADMIN_URL + 'purchase/id/'+ id);
   },

   deleteList(items: PurchaseDto[]): Promise<AxiosResponse<string>> {
      return axios.post(ADMIN_URL + 'purchase/multiple', items);
   },

   findPaginatedByCriteria(criteria:PurchaseCriteria):Promise<AxiosResponse<PaginatedList<PurchaseDto>>> {
     return axios.post<PaginatedList<PurchaseDto>>(ADMIN_URL + 'purchase/find-paginated-by-criteria', criteria);
   }
};

