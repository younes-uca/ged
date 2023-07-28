import axios, { AxiosResponse } from "axios";
import { ADMIN_URL } from 'layout/AppConfig';
import {PaginatedList} from 'app/zynerator/dto/PaginatedList.model';
import {ProductDto} from 'app/controller/model/Product.model';
import {ProductCriteria} from 'app/controller/criteria/ProductCriteria.model';



export const ProductAdminService = {

   getList(): Promise<AxiosResponse<ProductDto[]>> {
     return axios.get(ADMIN_URL + 'product/');
   },

   save(item: ProductDto): Promise<AxiosResponse<ProductDto>> {
     return axios.post(ADMIN_URL + 'product/', item);
   },

   update(item: ProductDto): Promise<AxiosResponse<ProductDto>> {
      return axios.put(ADMIN_URL + 'product/', item);
   },

   delete(id: number): Promise<AxiosResponse<ProductDto>> {
      return axios.delete(ADMIN_URL + 'product/id/'+ id);
   },

   deleteList(items: ProductDto[]): Promise<AxiosResponse<string>> {
      return axios.post(ADMIN_URL + 'product/multiple', items);
   },

   findPaginatedByCriteria(criteria:ProductCriteria):Promise<AxiosResponse<PaginatedList<ProductDto>>> {
     return axios.post<PaginatedList<ProductDto>>(ADMIN_URL + 'product/find-paginated-by-criteria', criteria);
   }
};

