import axios, { AxiosResponse } from "axios";
import { ADMIN_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {PurchaseItemDto} from 'app/controller/model/PurchaseItem.model';
import {PurchaseItemCriteria} from 'app/controller/criteria/PurchaseItemCriteria.model';



export const PurchaseItemAdminService = {

   getList(): Promise<AxiosResponse<PurchaseItemDto[]>> {
     return axios.get(ADMIN_URL + 'purchaseItem/');
   },

   save(item: PurchaseItemDto): Promise<AxiosResponse<PurchaseItemDto>> {
     return axios.post(ADMIN_URL + 'purchaseItem/', item);
   },

   update(item: PurchaseItemDto): Promise<AxiosResponse<PurchaseItemDto>> {
      return axios.put(ADMIN_URL + 'purchaseItem/', item);
   },

   delete(id: number): Promise<AxiosResponse<PurchaseItemDto>> {
      return axios.delete(ADMIN_URL + 'purchaseItem/id/'+ id);
   },

   deleteList(items: PurchaseItemDto[]): Promise<AxiosResponse<string>> {
      return axios.post(ADMIN_URL + 'purchaseItem/multiple', items);
   },

   findPaginatedByCriteria(criteria:PurchaseItemCriteria):Promise<AxiosResponse<PaginatedList<PurchaseItemDto>>> {
     return axios.post<PaginatedList<PurchaseItemDto>>(ADMIN_URL + 'purchaseItem/find-paginated-by-criteria', criteria);
   }
};

