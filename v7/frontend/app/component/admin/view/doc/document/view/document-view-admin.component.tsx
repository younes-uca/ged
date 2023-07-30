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
import { InputSwitch } from 'primereact/inputswitch';
import {MultiSelect} from 'primereact/multiselect';
import  {DocumentDto}  from 'app/controller/model/Document.model';

const View = ({visible,onClose,selectedItem}) => {

    const emptyItem = new DocumentDto();
    const [item, setItem] = useState<DocumentDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);

    useEffect(() => {
        setItem(selectedItem ? { ...selectedItem } : { ...emptyItem });
    }, [selectedItem]);

    const onTabChange = (e: { index: number }) => {
        setActiveIndex(e.index);
    };

    const hideDialog = () => {
        setSubmitted(false);
        onClose();
    };

    const itemDialogFooter = ( <>
        <Button label="Cancel" icon="pi pi-times" text onClick={hideDialog} /> </>
    );

return(
<Dialog visible={visible} style={{width: '70vw'}} header="Document Details" modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header="Document">
    <div className="formgrid grid">

            <div className="field col-6">
                <label htmlFor="reference">Reference</label>
                <InputText id="reference" value={selectedItem?.reference} disabled   />
            </div>

        <div className="field col-6">
            <label htmlFor="uploadDate">Upload date</label>
            <Calendar id="uploadDate" value={selectedItem?.uploadDate} disabled dateFormat="dd/mm/yy" showTime />
        </div>

        <div className="field col-6">
            <label htmlFor="dateLastUpdate">Date last update</label>
            <Calendar id="dateLastUpdate" value={selectedItem?.dateLastUpdate} disabled dateFormat="dd/mm/yy" showTime />
        </div>

            <div className="field col-6">
                <label htmlFor="content">Content</label>
                <InputText id="content" value={selectedItem?.content} disabled   />
            </div>

        <div className="field col-6">
            <div  class="label-inputswitch">
                <label htmlFor="folder">Folder</label>
                <span className="p-float-label">
            <InputSwitch  id="folder" checked={selectedItem?.folder} disabled />
             </span>
            </div>
            </div>

                <div className="field col-6">
                    <label htmlFor="size">Size</label>
                    <InputNumber id="size" value={item.size} disabled/>
                </div>

                <div className="field col-6">
                    <label htmlFor="documentType">Document type</label>
                    <Dropdown  id="documentTypeDropdown"  value={selectedItem?.documentType?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="documentState">Document state</label>
                    <Dropdown  id="documentStateDropdown"  value={selectedItem?.documentState?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="documentCategorie">Document categorie</label>
                    <Dropdown  id="documentCategorieDropdown"  value={selectedItem?.documentCategorie?.libelle}  disabled  />
                </div>
            <div className="field col-6">
                <label htmlFor="description">Description</label>
                <span className="p-float-label">
                   <InputTextarea id="description" value={selectedItem?.description} disabled rows={5} cols={30} />
                </span>
            </div>

                <div className="field col-6">
                    <label htmlFor="proprietaire">Proprietaire</label>
                    <Dropdown  id="proprietaireDropdown"  value={selectedItem?.proprietaire?.nom}  disabled  />
                </div>
        <div className="field col-6">
            <div  class="label-inputswitch">
                <label htmlFor="archive">Archive</label>
                <span className="p-float-label">
            <InputSwitch  id="archive" checked={selectedItem?.archive} disabled />
             </span>
            </div>
            </div>

        <div className="field col-6">
            <div  class="label-inputswitch">
                <label htmlFor="versionne">Versionne</label>
                <span className="p-float-label">
            <InputSwitch  id="versionne" checked={selectedItem?.versionne} disabled />
             </span>
            </div>
            </div>

                <div className="field col-6">
                    <label htmlFor="entiteAdministrative">Entite administrative</label>
                    <Dropdown  id="entiteAdministrativeDropdown"  value={selectedItem?.entiteAdministrative?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="entiteAdministrativeProprietaire">Entite administrative proprietaire</label>
                    <Dropdown  id="entiteAdministrativeProprietaireDropdown"  value={selectedItem?.entiteAdministrativeProprietaire?.libelle}  disabled  />
                </div>
        </div>
</TabPanel>
    <TabPanel header="Document fields">
                <div className="card">
                    <DataTable value={selectedItem?.documentFields} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="field.libelle" header="Field"></Column>
                                <Column field="value" header="Value"></Column>
                                <Column field="documentFieldState.libelle" header="Document field state"></Column>
                    </DataTable>
                </div>
        </TabPanel>
    <TabPanel header="Document partage groupes">
                <div className="card">
                    <DataTable value={selectedItem?.documentPartageGroupes} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="groupe.libelle" header="Groupe"></Column>
                                <Column field="dateShare" header="Date share"></Column>
                                <Column field="accessShare.libelle" header="Access share"></Column>
                    </DataTable>
                </div>
        </TabPanel>
    <TabPanel header="Document partage utilisateurs">
                <div className="card">
                    <DataTable value={selectedItem?.documentPartageUtilisateurs} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="utilisateur.nom" header="Utilisateur"></Column>
                                <Column field="dateShare" header="Date share"></Column>
                                <Column field="accessShare.libelle" header="Access share"></Column>
                    </DataTable>
                </div>
        </TabPanel>
</TabView>
</Dialog>
);
};
export default View;
