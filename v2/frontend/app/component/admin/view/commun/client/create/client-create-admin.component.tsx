import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber, InputNumberChangeEvent} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import { InputTextarea } from 'primereact/inputtextarea';
import {AxiosResponse} from 'axios';
import React, {useEffect, useState} from 'react';
import {Calendar, CalendarChangeEvent} from 'primereact/calendar';
import { format } from 'date-fns';
import {InputNumberChangeEvent} from 'primereact/inputnumber';
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect} from 'primereact/multiselect';


import {MessageService} from '../../../../../../controller/service/MessageService';

import {ClientService} from '../../../../../../controller/service/Client.service';
import  {ClientDto}  from '../../../../../../controller/model/Client.model';

import {ClientCategoryDto} from '../../../../../../controller/model/ClientCategory.model';
import {ClientCategoryService} from '../../../../../../controller/service/ClientCategory.service';
const Create = ({visible, onClose, add, showToast, list}) => {

    const emptyItem = new ClientDto();
    const [items, setItems] = useState<ClientDto[]>([list]);
    const [item, setItem] = useState<ClientDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);

    const [clientCategorys, setClientCategorys] = useState<ClientCategoryDto[]>([]);

    type ClientCategoryResponse = AxiosResponse<ClientCategoryDto[]>;


    useEffect(() => {
        const fetchData = async () => {
            try {
                const [clientCategorysResponse ] = await Promise.all<ClientCategoryResponse>([
                    ClientCategoryService.getList(),
                ]);
                setClientCategorys(clientCategorysResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
        fetchData();
    }, []);

    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onTabChange = (e: { index: number }) => { setActiveIndex(e.index); };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };


    const isFormValid = () => {
        let errorMessages = new Array<string>();
        if(item.fullName == '')
            errorMessages.push("fullName is required")
        if(item.email == '')
            errorMessages.push("email is required")
        return errorMessages.length == 0 ;
    }
    const saveItem = async () => {
        setSubmitted(true);
        if (isFormValid()) {
            const response = await ClientService.save(item);
            add(response.data);
            MessageService.showSuccess(showToast, 'Client Created');
            onClose();
            setItem(emptyItem);
            setSubmitted(false);
        }
    };

    const onInputTextChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const value = (e.target && e.target.value) || '';
        setItem({ ...item, [name]: value });
    };

    const onInputDateChange = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || '';
        let _item = { ...item};
        _item[`${name}`] = val;
        setItem(_item);
    };

    const onInputNumerChange = (e: InputNumberChangeEvent, name: string) => {
        const val = e.value === null ? null : +e.value;
        setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onMultiSelectChange = (e, field) => {
      if (e && e.value && Array.isArray(e.value)) {
         const selectedValues = e.value.map(option => option && option.value);
         setItem(prevState => ({ ...prevState, [field]: selectedValues, }));
      }
    };

    const onBooleanInputChange = (e: any, name: string) => {
       const val = e.value;
       setItem((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} />
        <Button label="Save" icon="pi pi-check" text onClick={saveItem} /> </>
    );

return(
    <Dialog visible={visible} style={{width: '70vw'}} header="Client" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Client">
                <div className="formgrid grid">
                    <div className="field col-6">
                    <label htmlFor="fullName">FullName</label>
                    <InputText id="fullName" value={item.fullName} onChange={(e) => onInputTextChange(e, 'fullName')} required autoFocus className={classNames({'p-invalid': submitted && !item.fullName})} />
                    {submitted && !item.fullName && <small className="p-invalid">FullName is required.</small>}
                    </div>
                    <div className="field col-6">
                    <label htmlFor="email">Email</label>
                    <InputText id="email" value={item.email} onChange={(e) => onInputTextChange(e, 'email')} required autoFocus className={classNames({'p-invalid': submitted && !item.email})} />
                    {submitted && !item.email && <small className="p-invalid">Email is required.</small>}
                    </div>
                    <div className="field col-6">
                    <label htmlFor="clientCategory">ClientCategory</label>
                    <Dropdown  id="clientCategoryDropdown"  value={item.clientCategory} options={clientCategorys} onChange={(e) => onDropdownChange(e, 'clientCategory')}   placeholder="Sélectionnez un clientCategory" filter filterPlaceholder="Rechercher un clientCategory" optionLabel="reference" />
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
