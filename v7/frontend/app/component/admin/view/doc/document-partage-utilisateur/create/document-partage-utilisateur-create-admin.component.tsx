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

import {DocumentPartageUtilisateurAdminService} from 'app/controller/service/admin/DocumentPartageUtilisateurAdminService.service';
import  {DocumentPartageUtilisateurDto}  from 'app/controller/model/DocumentPartageUtilisateur.model';

import {AccessShareDto} from 'app/controller/model/AccessShare.model';
import {AccessShareAdminService} from 'app/controller/service/admin/AccessShareAdminService.service';
import {DocumentDto} from 'app/controller/model/Document.model';
import {DocumentAdminService} from 'app/controller/service/admin/DocumentAdminService.service';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';
const Create = ({visible, onClose, add, showToast, list}) => {

    const emptyItem = new DocumentPartageUtilisateurDto();
    const [items, setItems] = useState<DocumentPartageUtilisateurDto[]>([list]);
    const [item, setItem] = useState<DocumentPartageUtilisateurDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);

    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    const [documents, setDocuments] = useState<DocumentDto[]>([]);
    const [accessShares, setAccessShares] = useState<AccessShareDto[]>([]);

    type AccessShareResponse = AxiosResponse<AccessShareDto[]>;
    type DocumentResponse = AxiosResponse<DocumentDto[]>;
    type UtilisateurResponse = AxiosResponse<UtilisateurDto[]>;


    useEffect(() => {
        const fetchData = async () => {
            try {
                const [utilisateursResponse ,documentsResponse ,accessSharesResponse ] = await Promise.all<UtilisateurResponse,DocumentResponse,AccessShareResponse>([
                    UtilisateurAdminService.getList(),
                    DocumentAdminService.getList(),
                    AccessShareAdminService.getList(),
                ]);
                setUtilisateurs(utilisateursResponse.data);
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
            const response = await DocumentPartageUtilisateurAdminService.save(item);
            add(response.data);
            MessageService.showSuccess(showToast, 'DocumentPartageUtilisateur Created');
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
    <Dialog visible={visible} style={{width: '70vw'}} header="DocumentPartageUtilisateur" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Document partage utilisateur">
                <div className="formgrid grid">
                    <div className="field col-6">
                    <label htmlFor="document">Document</label>
                    <Dropdown  id="documentDropdown"  value={item.document} options={documents} onChange={(e) => onDropdownChange(e, 'document')}   placeholder="Sélectionnez un document" filter filterPlaceholder="Rechercher un document" optionLabel="reference" />
                    </div>
                    <div className="field col-6">
                    <label htmlFor="utilisateur">Utilisateur</label>
                    <Dropdown  id="utilisateurDropdown"  value={item.utilisateur} options={utilisateurs} onChange={(e) => onDropdownChange(e, 'utilisateur')}   placeholder="Sélectionnez un utilisateur" filter filterPlaceholder="Rechercher un utilisateur" optionLabel="nom" />
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
