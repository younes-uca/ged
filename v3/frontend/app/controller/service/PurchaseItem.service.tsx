import axios, { AxiosResponse } from "axios";
import { API_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {PurchaseItemDto} from 'app/controller/model/PurchaseItem.model';
import {PurchaseItemCriteria} from 'app/controller/criteria/PurchaseItemCriteria.model';



export const PurchaseItemService = {

   getList(): Promise<AxiosResponse<PurchaseItemDto[]>> {
     return axios.get(API_URL + 'purchaseItem/');
   },

   save(item: PurchaseItemDto): Promise<AxiosResponse<PurchaseItemDto>> {
     return axios.post(API_URL + 'purchaseItem/', item);
   },

   update(item: PurchaseItemDto): Promise<AxiosResponse<PurchaseItemDto>> {
      return axios.put(API_URL + 'purchaseItem/', item);
   },

   delete(id: number): Promise<AxiosResponse<PurchaseItemDto>> {
      return axios.delete(API_URL + 'purchaseItem/id/'+ id);
   },

   deleteList(items: PurchaseItemDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'purchaseItem/multiple', items);
   },

   findPaginatedByCriteria(criteria:PurchaseItemCriteria):Promise<AxiosResponse<PaginatedList<PurchaseItemDto>>> {
     return axios.post<PaginatedList<PurchaseItemDto>>(API_URL + 'purchaseItem/find-paginated-by-criteria', criteria);
   }
};

