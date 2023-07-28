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
            <label htmlFor="uploadDate">UploadDate</label>
            <Calendar id="uploadDate" value={selectedItem?.uploadDate} disabled dateFormat="dd/mm/yy" showTime />
        </div>

        <div className="field col-6">
            <label htmlFor="dateLastUpdate">DateLastUpdate</label>
            <Calendar id="dateLastUpdate" value={selectedItem?.dateLastUpdate} disabled dateFormat="dd/mm/yy" showTime />
        </div>

            <div className="field col-6">
                <label htmlFor="content">Content</label>
                <InputText id="content" value={selectedItem?.content} disabled   />
            </div>

                <div className="field col-6">
                    <label htmlFor="size">Size</label>
                    <InputNumber id="size" value={item.size} disabled/>
                </div>

                <div className="field col-6">
                    <label htmlFor="documentType">DocumentType</label>
                    <Dropdown  id="documentTypeDropdown"  value={selectedItem?.documentType?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="documentState">DocumentState</label>
                    <Dropdown  id="documentStateDropdown"  value={selectedItem?.documentState?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="documentCategorie">DocumentCategorie</label>
                    <Dropdown  id="documentCategorieDropdown"  value={selectedItem?.documentCategorie?.libelle}  disabled  />
                </div>
            <div className="field col-6">
                <label htmlFor="description">Description</label>
                <span className="p-float-label">
                   <InputTextarea id="description" value={selectedItem?.description} disabled rows={5} cols={30} />
                </span>
            </div>

                <div className="field col-6">
                    <label htmlFor="utilisateur">Utilisateur</label>
                    <Dropdown  id="utilisateurDropdown"  value={selectedItem?.utilisateur?.name}  disabled  />
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
                    <label htmlFor="entiteAdministrative">EntiteAdministrative</label>
                    <Dropdown  id="entiteAdministrativeDropdown"  value={selectedItem?.entiteAdministrative?.libelle}  disabled  />
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
                                <Column field="acessShare.libelle" header="Acess share"></Column>
                    </DataTable>
                </div>
        </TabPanel>
    <TabPanel header="Document partage utilisateurs">
                <div className="card">
                    <DataTable value={selectedItem?.documentPartageUtilisateurs} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="utilisateur.name" header="Utilisateur"></Column>
                                <Column field="dateShare" header="Date share"></Column>
                                <Column field="acessShare.libelle" header="Acess share"></Column>
                    </DataTable>
                </div>
        </TabPanel>
    <TabPanel header="Document management groupes">
                <div className="card">
                    <DataTable value={selectedItem?.documentManagementGroupes} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="groupe.libelle" header="Groupe"></Column>
                                <Column field="dateManagement" header="Date management"></Column>
                                <Column field="acessManagement.libelle" header="Acess management"></Column>
                    </DataTable>
                </div>
        </TabPanel>
    <TabPanel header="Document management utilisateurs">
                <div className="card">
                    <DataTable value={selectedItem?.documentManagementUtilisateurs} tableStyle={{minWidth: '50rem'}} dataKey="id">
                                <Column field="utilisateur.name" header="Utilisateur"></Column>
                                <Column field="dateManagement" header="Date management"></Column>
                                <Column field="acessManagement.libelle" header="Acess management"></Column>
                    </DataTable>
                </div>
        </TabPanel>
</TabView>
</Dialog>
);
};
export default View;
