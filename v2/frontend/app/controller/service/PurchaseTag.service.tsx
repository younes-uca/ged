import axios, { AxiosResponse } from "axios";
import { API_URL } from '../../../layout/AppConfig';
import {PaginatedList} from '../../zynerator/dto/PaginatedList.model';
import {PurchaseTagDto} from '../../controller/model/PurchaseTag.model';
import {PurchaseTagCriteria} from '../../controller/criteria/PurchaseTagCriteria.model';



export const PurchaseTagService = {

   getList(): Promise<AxiosResponse<PurchaseTagDto[]>> {
     return axios.get(API_URL + 'purchaseTag/');
   },

   save(item: PurchaseTagDto): Promise<AxiosResponse<PurchaseTagDto>> {
     return axios.post(API_URL + 'purchaseTag/', item);
   },

   update(item: PurchaseTagDto): Promise<AxiosResponse<PurchaseTagDto>> {
      return axios.put(API_URL + 'purchaseTag/', item);
   },

   delete(id: number): Promise<AxiosResponse<PurchaseTagDto>> {
      return axios.delete(API_URL + 'purchaseTag/id/'+ id);
   },

   deleteList(items: PurchaseTagDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'purchaseTag/multiple', items);
   },

   findPaginatedByCriteria(criteria:PurchaseTagCriteria):Promise<AxiosResponse<PaginatedList<PurchaseTagDto>>> {
     return axios.post<PaginatedList<PurchaseTagDto>>(API_URL + 'purchaseTag/find-paginated-by-criteria', criteria);
   }
};

