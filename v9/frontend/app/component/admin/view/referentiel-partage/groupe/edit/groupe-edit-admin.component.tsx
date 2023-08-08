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

import {MessageService} from 'app/zynerator/service/MessageService';

import {GroupeAdminService} from 'app/controller/service/admin/GroupeAdminService.service';
import  {GroupeDto}  from 'app/controller/model/Groupe.model';

import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';
import {UtilisateurAdminService} from 'app/controller/service/admin/UtilisateurAdminService.service';
import {GroupeUtilisateurDto} from 'app/controller/model/GroupeUtilisateur.model';
import {GroupeUtilisateurAdminService} from 'app/controller/service/admin/GroupeUtilisateurAdminService.service';
import {EtatUtilisateurDto} from 'app/controller/model/EtatUtilisateur.model';
import {EtatUtilisateurAdminService} from 'app/controller/service/admin/EtatUtilisateurAdminService.service';
import {RoleUtilisateurDto} from 'app/controller/model/RoleUtilisateur.model';
import {RoleUtilisateurAdminService} from 'app/controller/service/admin/RoleUtilisateurAdminService.service';
const Edit = ({visible, onClose, showToast, selectedItem, update, t}) => {

    const emptyItem = new GroupeDto();
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const [item, setItem] = useState<GroupeDto>( emptyItem);
    const [utilisateurs, setUtilisateurs] = useState<UtilisateurDto[]>([]);
    const [etatUtilisateurs, setEtatUtilisateurs] = useState<EtatUtilisateurDto[]>([]);
    const [roleUtilisateurs, setRoleUtilisateurs] = useState<RoleUtilisateurDto[]>([]);

    type UtilisateurResponse = AxiosResponse<UtilisateurDto[]>;
    type GroupeUtilisateurResponse = AxiosResponse<GroupeUtilisateurDto[]>;
    type EtatUtilisateurResponse = AxiosResponse<EtatUtilisateurDto[]>;
    type RoleUtilisateurResponse = AxiosResponse<RoleUtilisateurDto[]>;

    const [groupeUtilisateurs, setGroupeUtilisateurs] = useState<GroupeUtilisateurDto>(new GroupeUtilisateurDto());

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [utilisateursResponse ,etatUtilisateursResponse ,roleUtilisateursResponse ] = await Promise.all<UtilisateurResponse,EtatUtilisateurResponse,RoleUtilisateurResponse>([
                    UtilisateurAdminService.getList(),
                    EtatUtilisateurAdminService.getList(),
                    RoleUtilisateurAdminService.getList(),
                ]);
                setUtilisateurs(utilisateursResponse.data);
                setEtatUtilisateurs(etatUtilisateursResponse.data);
                setRoleUtilisateurs(roleUtilisateursResponse.data);
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

    const addGroupeUtilisateurs = () => {
        setSubmitted(true);
        if( item.groupeUtilisateurs == null )
        item.groupeUtilisateurs = new Array<GroupeUtilisateurDto>();
        let _item = groupeUtilisateurs;
        if (!_item.id) {
            item.groupeUtilisateurs.push(_item);
            MessageService.showSuccess(showToast, 'GroupeUtilisateurs Created');
            setItem((prevState :any) => ({...prevState, groupeUtilisateurs: item.groupeUtilisateurs }));
        } else {
            const updatedItems = item.groupeUtilisateurs.map((item) => item.id === groupeUtilisateurs.id ? {...groupeUtilisateurs} : item);
            MessageService.showSuccess(showToast, 'GroupeUtilisateurs Updated');
            setItem((prevState :any) => ({ ...prevState, groupeUtilisateurs: updatedItems}));
        }
        setGroupeUtilisateurs(new GroupeUtilisateurDto());
    };

    const deleteGroupeUtilisateurs = (rowData) => {
        const updatedItems = item.groupeUtilisateurs.filter((val) => val !== rowData);
        setItem((prevState ) => ({...prevState, groupeUtilisateurs: updatedItems }));
        setGroupeUtilisateurs(new GroupeUtilisateurDto());
        MessageService.showSuccess(showToast, 'GroupeItem Deleted');
    };

    const editGroupeUtilisateurs = (rowData) => {
        setActiveTab(0);
        setGroupeUtilisateurs(rowData);
    };

    const onInputNumerChangeGroupeUtilisateurs = (e, name) => {
        const val = e.value || 0;
        setGroupeUtilisateurs((prevGroupeUtilisateurs) => ({ ...prevGroupeUtilisateurs, [name]: val, }));
    };

    const onDropdownChangeGroupeUtilisateurs = (e, field) => {
        setGroupeUtilisateurs((prevState) => ({ ...prevState, [field]: e.value}));
    };


    const onMultiSelectChangeGroupeUtilisateurs = (e, field) => {
        if (e && e.value && Array.isArray(e.value)) {
            const selectedValues = e.value.map(option => option && option.value);
            setGroupeUtilisateurs(prevState => ({ ...prevState, [field]: selectedValues, }));
        }
    };

    const onBooleanInputChangeGroupeUtilisateurs = (e: any, name: string) => {
        const val = e.value;
        setGroupeUtilisateurs((prevItem) => ({ ...prevItem, [name]: val, }));
    };

    const onInputDateChangeGroupeUtilisateurs = (e: CalendarChangeEvent, name: string) => {
        const val = e.value || ''; // Utilisez e.value au lieu de e.target.value
        let _item = { ...groupeUtilisateurs};
        _item[`${name}`] = val;
        setGroupeUtilisateurs(_item);
    };


    const onInputTextChangeGroupeUtilisateurs = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _item = {...groupeUtilisateurs};
        _item[`${name}`] = val;
        setGroupeUtilisateurs(_item);
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
        if(item.code == '')
        errorMessages.push("code is required")
        if(item.libelle == '')
        errorMessages.push("libelle is required")
        return errorMessages.length == 0 ;
    }
    const editItem = async () => {
        setSubmitted(true);
        if (isFormValid()) {
            const response = await GroupeAdminService.update(item);
            update(response.data);
            MessageService.showSuccess(showToast, 'Groupe Updated');
            onClose();
            setItem(emptyItem);
            setSubmitted(false);
            setItem({...item, GroupeUtilisateurs: null, });
            setGroupeUtilisateurs(new GroupeUtilisateurDto());
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
    <Dialog visible={visible} style={{width: '70vw'}} header={t("groupeTabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog}>
        <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
            <TabPanel header={t("groupeTabPan")}>
                <div className="formgrid grid">
                    <div className="field col-6">
                        <label htmlFor="code">{t("groupeCode")}</label>
                        <InputText id="code" value={item ? item.code : ''} onChange={(e) => onInputTextChange(e, 'code')} required autoFocus className={classNames({'p-invalid': submitted && !item.code})} />
                        {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="libelle">{t("groupeLibelle")}</label>
                        <InputText id="libelle" value={item ? item.libelle : ''} onChange={(e) => onInputTextChange(e, 'libelle')} required autoFocus className={classNames({'p-invalid': submitted && !item.libelle})} />
                        {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                    </div>
                    <div className="field col-6">
                        <label htmlFor="utilisateur">{t("groupeUtilisateur")}</label>
                        <Dropdown  id="utilisateurDropdown"  value={item ? item.utilisateur : ''} options={utilisateurs} onChange={(e) => onDropdownChange(e, 'utilisateur')}   placeholder="Sélectionnez un utilisateur" filter filterPlaceholder="Rechercher un utilisateur" optionLabel="nom" />
                    </div>
                </div>
            </TabPanel>
            <TabPanel header={t("groupeGroupeUtilisateurs")}>
                <TabView activeIndex={activeTab} onTabChange={(e) => setActiveTab(e.index)}>
                    <TabPanel header="Creation">
                        <div className="grid">
                            <div className="field col-6">
                                <label htmlFor="utilisateur">{t("groupeUtilisateurUtilisateur")}</label>
                                <Dropdown id="utilisateurDropdown" value={groupeUtilisateurs.utilisateur} options={utilisateurs} onChange={(e) => onDropdownChangeGroupeUtilisateurs(e, 'utilisateur')} placeholder="Sélectionnez un utilisateur" filter  filterPlaceholder="Rechercher un utilisateur"  optionLabel="nom" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="dateAjout">{t("groupeUtilisateurDateAjout")}</label>
                                <Calendar id="dateAjout" value={groupeUtilisateurs?.dateAjout}  onChange={(e) => onInputDateChangeGroupeUtilisateurs(e, 'dateAjout')} dateFormat="dd/mm/yy" showTime  />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="etatUtilisateur">{t("groupeUtilisateurEtatUtilisateur")}</label>
                                <Dropdown id="etatUtilisateurDropdown" value={groupeUtilisateurs.etatUtilisateur} options={etatUtilisateurs} onChange={(e) => onDropdownChangeGroupeUtilisateurs(e, 'etatUtilisateur')} placeholder="Sélectionnez un etatUtilisateur" filter  filterPlaceholder="Rechercher un etatUtilisateur"  optionLabel="libelle" />
                            </div>
                            <div className="field col-6">
                                <label htmlFor="roleUtilisateur">{t("groupeUtilisateurRoleUtilisateur")}</label>
                                <Dropdown id="roleUtilisateurDropdown" value={groupeUtilisateurs.roleUtilisateur} options={roleUtilisateurs} onChange={(e) => onDropdownChangeGroupeUtilisateurs(e, 'roleUtilisateur')} placeholder="Sélectionnez un roleUtilisateur" filter  filterPlaceholder="Rechercher un roleUtilisateur"  optionLabel="libelle" />
                            </div>
                            <div className="field col-1">
                                <Button icon="pi pi-plus" label="OK" className="mt-4" onClick={addGroupeUtilisateurs} />
                            </div>
                        </div>
                    </TabPanel>
                    <TabPanel header="Liste">
                        <div className="card">
                            <DataTable value={item.groupeUtilisateurs} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="utilisateur.nom" header={t("groupeUtilisateurUtilisateur")}></Column>
                                <Column field="dateAjout" header={t("groupeUtilisateurDateAjout")}></Column>
                                <Column field="etatUtilisateur.libelle" header={t("groupeUtilisateurEtatUtilisateur")}></Column>
                                <Column field="roleUtilisateur.libelle" header={t("groupeUtilisateurRoleUtilisateur")}></Column>
                                <Column header="Actions" body={(rowData) => (
                                    <div>
                                        <Button icon="pi pi-times" rounded severity="warning" className="mr-2 p-button-danger" onClick={()=> deleteGroupeUtilisateurs(rowData)} />
                                        <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={()=> editGroupeUtilisateurs(rowData)} />
                                    </div>
                                )}></Column>
                            </DataTable>
                        </div>
                    </TabPanel>
                </TabView>
            </TabPanel>
        </TabView>
    </Dialog>
);
};
export default Edit;


