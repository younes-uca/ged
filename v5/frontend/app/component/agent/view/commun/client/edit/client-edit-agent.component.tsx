import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {Dropdown} from 'primereact/dropdown';
import {TabView, TabPanel} from 'primereact/tabview';
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

import {MessageService} from 'app/zynerator/service/MessageService';

import {ClientService} from 'app/controller/service/Client.service';
import  {ClientDto}  from 'app/controller/model/Client.model';

import {ClientCategoryDto} from 'app/controller/model/ClientCategory.model';
import {ClientCategoryService} from 'app/controller/service/ClientCategory.service';
const Edit = ({visible, onClose, showToast, selectedItem, update}) => {

    const emptyItem = new ClientDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<ClientDto>( emptyItem);
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
    setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);



    const onDropdownChange = (e, field) => {
        setItem((prevState) => ({ ...prevState, [field]: e.value, }));
    };


    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

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
        if(item.dateRegistration == '')
        errorMessages.push("dateRegistration is required")
        if(item.nombreEnfant == '')
        errorMessages.push("nombreEnfant is required")
        return errorMessages.length == 0 ;
    }
    const editItem = async () => {
        setSubmitted(true);
        if (isFormValid()) {
            const response = await ClientService.update(item);
            update(response.data);
            MessageService.showSuccess(showToast, 'Client Updated');
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
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
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
        <Button label="Save" icon="pi pi-check" text onClick={editItem} /> </>
    );

return(
    <Dialog visible={visible} style={{width: '70vw'}} header="Client" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Client">
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="fullName">FullName</label>
                        <InputText id="fullName" value={item ? item.fullName : ''} onChange={(e) => onInputTextChange(e, 'fullName')} required autoFocus className={classNames({'p-invalid': submitted && !item.fullName})} />
                        {submitted && !item.fullName && <small className="p-invalid">FullName is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="email">Email</label>
                        <InputText id="email" value={item ? item.email : ''} onChange={(e) => onInputTextChange(e, 'email')} required autoFocus className={classNames({'p-invalid': submitted && !item.email})} />
                        {submitted && !item.email && <small className="p-invalid">Email is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="dateRegistration">DateRegistration</label>
                        <Calendar id="dateRegistration" value={item ? item.dateRegistration : ''} onChange={(e) => onInputDateChange(e, 'dateRegistration')} dateFormat="dd/mm/yy" showTime />
                    </div>
                    <div className="field col-6">
                        <label htmlFor="nombreEnfant">NombreEnfant</label>
                        <InputNumber id="nombreEnfant" value={item ? item.nombreEnfant : 0} onChange={(e) => onInputNumerChange(e, 'nombreEnfant')}/>
                    </div>
                    <div className="field col-6">
                        <label htmlFor="clientCategory">ClientCategory</label>
                        <Dropdown  id="clientCategoryDropdown"  value={item ? item.clientCategory : ''} options={clientCategorys} onChange={(e) => onDropdownChange(e, 'clientCategory')}   placeholder="Sélectionnez un clientCategory" filter filterPlaceholder="Rechercher un clientCategory" optionLabel="reference" />
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


