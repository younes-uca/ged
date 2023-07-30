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

import {DocumentPartageGroupeAdminService} from 'app/controller/service/admin/DocumentPartageGroupeAdminService.service';
import  {DocumentPartageGroupeDto}  from 'app/controller/model/DocumentPartageGroupe.model';

import {AccessShareDto} from 'app/controller/model/AccessShare.model';
import {AccessShareAdminService} from 'app/controller/service/admin/AccessShareAdminService.service';
import {DocumentDto} from 'app/controller/model/Document.model';
import {DocumentAdminService} from 'app/controller/service/admin/DocumentAdminService.service';
import {GroupeDto} from 'app/controller/model/Groupe.model';
import {GroupeAdminService} from 'app/controller/service/admin/GroupeAdminService.service';
const Create = ({visible, onClose, add, showToast, list}) => {

    const emptyItem = new DocumentPartageGroupeDto();
    const [items, setItems] = useState<DocumentPartageGroupeDto[]>([list]);
    const [item, setItem] = useState<DocumentPartageGroupeDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);

    const [groupes, setGroupes] = useState<GroupeDto[]>([]);
    const [documents, setDocuments] = useState<DocumentDto[]>([]);
    const [accessShares, setAccessShares] = useState<AccessShareDto[]>([]);

    type AccessShareResponse = AxiosResponse<AccessShareDto[]>;
    type DocumentResponse = AxiosResponse<DocumentDto[]>;
    type GroupeResponse = AxiosResponse<GroupeDto[]>;


    useEffect(() => {
        const fetchData = async () => {
            try {
                const [groupesResponse ,documentsResponse ,accessSharesResponse ] = await Promise.all<GroupeResponse,DocumentResponse,AccessShareResponse>([
                    GroupeAdminService.getList(),
                    DocumentAdminService.getList(),
                    AccessShareAdminService.getList(),
                ]);
                setGroupes(groupesResponse.data);
                setDocuments(documentsResponse.data);
                setAccessShares(accessSharesResponse.data);
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
        return errorMessages.length == 0 ;
    }
    const saveItem = async () => {
        setSubmitted(true);
        if (isFormValid()) {
            const response = await DocumentPartageGroupeAdminService.save(item);
            add(response.data);
            MessageService.showSuccess(showToast, 'DocumentPartageGroupe Created');
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
    <Dialog visible={visible} style={{width: '70vw'}} header="DocumentPartageGroupe" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Document partage groupe">
                <div className="formgrid grid">
                    <div className="field col-6">
                    <label htmlFor="document">Document</label>
                    <Dropdown  id="documentDropdown"  value={item.document} options={documents} onChange={(e) => onDropdownChange(e, 'document')}   placeholder="Sélectionnez un document" filter filterPlaceholder="Rechercher un document" optionLabel="reference" />
                    </div>
                    <div className="field col-6">
                    <label htmlFor="groupe">Groupe</label>
                    <Dropdown  id="groupeDropdown"  value={item.groupe} options={groupes} onChange={(e) => onDropdownChange(e, 'groupe')}   placeholder="Sélectionnez un groupe" filter filterPlaceholder="Rechercher un groupe" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                    <label htmlFor="dateShare">Date share</label>
                    <Calendar id="dateShare" value={item.dateShare} onChange={(e) => onInputDateChange(e, 'dateShare')} dateFormat="dd/mm/yy" showTime />
                    </div>
                    <div className="field col-6">
                    <label htmlFor="accessShare">Access share</label>
                    <Dropdown  id="accessShareDropdown"  value={item.accessShare} options={accessShares} onChange={(e) => onDropdownChange(e, 'accessShare')}   placeholder="Sélectionnez un accessShare" filter filterPlaceholder="Rechercher un accessShare" optionLabel="libelle" />
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
