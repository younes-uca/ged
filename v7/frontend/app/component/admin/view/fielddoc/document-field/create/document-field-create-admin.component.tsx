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

import {DocumentFieldAdminService} from 'app/controller/service/admin/DocumentFieldAdminService.service';
import  {DocumentFieldDto}  from 'app/controller/model/DocumentField.model';

import {DocumentFieldStateDto} from 'app/controller/model/DocumentFieldState.model';
import {DocumentFieldStateAdminService} from 'app/controller/service/admin/DocumentFieldStateAdminService.service';
import {FieldDto} from 'app/controller/model/Field.model';
import {FieldAdminService} from 'app/controller/service/admin/FieldAdminService.service';
import {DocumentDto} from 'app/controller/model/Document.model';
import {DocumentAdminService} from 'app/controller/service/admin/DocumentAdminService.service';
const Create = ({visible, onClose, add, showToast, list}) => {

    const emptyItem = new DocumentFieldDto();
    const [items, setItems] = useState<DocumentFieldDto[]>([list]);
    const [item, setItem] = useState<DocumentFieldDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);

    const [fields, setFields] = useState<FieldDto[]>([]);
    const [documents, setDocuments] = useState<DocumentDto[]>([]);
    const [documentFieldStates, setDocumentFieldStates] = useState<DocumentFieldStateDto[]>([]);

    type DocumentFieldStateResponse = AxiosResponse<DocumentFieldStateDto[]>;
    type FieldResponse = AxiosResponse<FieldDto[]>;
    type DocumentResponse = AxiosResponse<DocumentDto[]>;


    useEffect(() => {
        const fetchData = async () => {
            try {
                const [fieldsResponse ,documentsResponse ,documentFieldStatesResponse ] = await Promise.all<FieldResponse,DocumentResponse,DocumentFieldStateResponse>([
                    FieldAdminService.getList(),
                    DocumentAdminService.getList(),
                    DocumentFieldStateAdminService.getList(),
                ]);
                setFields(fieldsResponse.data);
                setDocuments(documentsResponse.data);
                setDocumentFieldStates(documentFieldStatesResponse.data);
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
            const response = await DocumentFieldAdminService.save(item);
            add(response.data);
            MessageService.showSuccess(showToast, 'DocumentField Created');
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
    <Dialog visible={visible} style={{width: '70vw'}} header="DocumentField" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header="Document field">
                <div className="formgrid grid">
                    <div className="field col-6">
                    <label htmlFor="field">Field</label>
                    <Dropdown  id="fieldDropdown"  value={item.field} options={fields} onChange={(e) => onDropdownChange(e, 'field')}   placeholder="Sélectionnez un field" filter filterPlaceholder="Rechercher un field" optionLabel="libelle" />
                    </div>
                    <div className="field col-6">
                    <label htmlFor="document">Document</label>
                    <Dropdown  id="documentDropdown"  value={item.document} options={documents} onChange={(e) => onDropdownChange(e, 'document')}   placeholder="Sélectionnez un document" filter filterPlaceholder="Rechercher un document" optionLabel="reference" />
                    </div>
                    <div className="field col-6">
                    <label htmlFor="value">Value</label>
                    <InputText id="value" value={item.value} onChange={(e) => onInputTextChange(e, 'value')} required autoFocus className={classNames({'p-invalid': submitted && !item.value})} />
                    {submitted && !item.value && <small className="p-invalid">Value is required.</small>}
                    </div>
                    <div className="field col-6">
                    <label htmlFor="documentFieldState">Document field state</label>
                    <Dropdown  id="documentFieldStateDropdown"  value={item.documentFieldState} options={documentFieldStates} onChange={(e) => onDropdownChange(e, 'documentFieldState')}   placeholder="Sélectionnez un documentFieldState" filter filterPlaceholder="Rechercher un documentFieldState" optionLabel="libelle" />
                    </div>
                </div>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Create;
