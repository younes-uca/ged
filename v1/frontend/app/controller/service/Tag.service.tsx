import axios, { AxiosResponse } from "axios";
import { API_URL } from '../../../layout/AppConfig';
import {PaginatedList} from '../../zynerator/dto/PaginatedList.model';
import {TagDto} from '../../controller/model/Tag.model';
import {TagCriteria} from '../../controller/criteria/TagCriteria.model';



export const TagService = {

   getList(): Promise<AxiosResponse<TagDto[]>> {
     return axios.get(API_URL + 'tag/');
   },

   save(item: TagDto): Promise<AxiosResponse<TagDto>> {
     return axios.post(API_URL + 'tag/', item);
   },

   update(item: TagDto): Promise<AxiosResponse<TagDto>> {
      return axios.put(API_URL + 'tag/', item);
   },

   delete(id: number): Promise<AxiosResponse<TagDto>> {
      return axios.delete(API_URL + 'tag/id/'+ id);
   },

   deleteList(items: TagDto[]): Promise<AxiosResponse<string>> {
      return axios.post(API_URL + 'tag/multiple', items);
   },

   findPaginatedByCriteria(criteria:TagCriteria):Promise<AxiosResponse<PaginatedList<TagDto>>> {
     return axios.post<PaginatedList<TagDto>>(API_URL + 'tag/find-paginated-by-criteria', criteria);
   }
};

