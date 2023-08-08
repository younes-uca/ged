import {Column} from 'primereact/column';
import {TabPanel, TabView} from 'primereact/tabview';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {InputNumber} from 'primereact/inputnumber';
import {InputText} from 'primereact/inputtext';
import {InputTextarea} from 'primereact/inputtextarea';
import React from 'react';
import {Calendar} from 'primereact/calendar';
import {InputSwitch} from 'primereact/inputswitch';
import {TFunction} from "i18next";
import useViewHook from "app/component/zyhook/useViewhook";

import  {DocumentCategorieFieldDto}  from 'app/controller/model/DocumentCategorieField.model';

type DocumentCategorieFieldViewAgentType = {
    visible: boolean,
    onClose: () => void,
    selectedItem: DocumentCategorieFieldDto,
    t: TFunction
}

const View: React.FC<DocumentCategorieFieldViewAgentType> = ({visible,onClose,selectedItem, t}) => {

    const {
    onTabChange,
    hideDialog,
    itemDialogFooter,
    formateDate,
    parse,
    parseToIsoFormat,
    adaptDate,
    activeIndex
    } = useViewHook<DocumentCategorieFieldDto>({selectedItem, onClose})


        return(
<Dialog visible={visible} style={{width: '70vw'}} header={t("documentCategorieField.tabPan")} modal className="p-fluid" footer={itemDialogFooter} onHide={hideDialog} >
<TabView activeIndex={activeIndex} onTabChange={onTabChange}>
<TabPanel header={t("documentCategorieField.tabPan")}>
    <div className="formgrid grid">

                <div className="field col-6">
                    <label htmlFor="field">{t("documentCategorieField.field")}</label>
                    <InputText  id="fieldDropdown"  value={selectedItem?.field?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="documentCategorie">{t("documentCategorieField.documentCategorie")}</label>
                    <InputText  id="documentCategorieDropdown"  value={selectedItem?.documentCategorie?.libelle}  disabled  />
                </div>
                <div className="field col-6">
                    <label htmlFor="documentCategorieFieldRule">{t("documentCategorieField.documentCategorieFieldRule")}</label>
                    <InputText  id="documentCategorieFieldRuleDropdown"  value={selectedItem?.documentCategorieFieldRule?.libelle}  disabled  />
                </div>
        </div>
</TabPanel>
</TabView>
</Dialog>
);
};
export default View;
