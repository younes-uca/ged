import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import {TabView, TabPanel} from 'primereact/tabview';
import {Dialog} from 'primereact/dialog';
import {InputText} from 'primereact/inputtext';
import {classNames} from 'primereact/utils';
import {InputTextarea} from 'primereact/inputtextarea';
import React, {useEffect, useState} from 'react';


import {MessageService} from 'app/zynerator/service/MessageService';

import {DocumentStateAdminService} from 'app/controller/service/admin/DocumentStateAdminService.service';
import {DocumentStateDto} from 'app/controller/model/DocumentState.model';

import {TFunction} from "i18next";
import {Toast} from "primereact/toast";
import useCreateHook from "../../../../../zyhooks/useHelperCreate.hook";

type DocumentStateCreateAdminType = {
    visible: boolean,
    onClose: () => void,
    add: (item: DocumentStateDto) => void,
    showToast: React.Ref<Toast>,
    list: DocumentStateDto[],
    t: TFunction
}
const Create: React.FC<DocumentStateCreateAdminType> = ({visible, onClose, add, showToast, list, t}) => {

    const emptyItem = new DocumentStateDto();
    const [items, setItems] = useState<DocumentStateDto[]>(list);
    const [item, setItem] = useState<DocumentStateDto>(emptyItem);
    const [submitted, setSubmitted] = useState(false);
    const [activeIndex, setActiveIndex] = useState<number>(0);
    const [activeTab, setActiveTab] = useState(0);
    const {
        onInputTextChange,
        onInputDateChange,
        onInputNumerChange,
        onMultiSelectChange,
        onBooleanInputChange,
        onTabChange,
        hideDialog
    } = useCreateHook<DocumentStateDto>({item, setItem, setActiveIndex, setSubmitted, onClose})


    useEffect(() => {

    }, []);


    const isFormValid = () => {
        let errorMessages = new Array<string>();
        if (item.code == '')
            errorMessages.push("code is required")
        if (item.libelle == '')
            errorMessages.push("libelle is required")
        return errorMessages.length == 0;
    }
    const saveItem = () => {
        setSubmitted(true);
        if (isFormValid()) {
            DocumentStateAdminService.save(item).then(({data}) => {
                add(data);
                MessageService.showSuccess(showToast, 'Document state Created');
                onClose();
                setSubmitted(false);
            });
        }
    };

    const itemDialogFooter = (<>
            <Button label={t("cancel")} icon="pi pi-times" text onClick={hideDialog}/>
            <Button label={t("save")} icon="pi pi-check" text onClick={saveItem}/> </>
    );

    return (
        <Dialog visible={visible} style={{width: '70vw'}} header={t("documentStateTabPan")} modal className="p-fluid"
                footer={itemDialogFooter} onHide={hideDialog}>
            <TabView activeIndex={activeIndex} onTabChange={onTabChange}>
                <TabPanel header={t("documentStateTabPan")}>
                    <div className="formgrid grid">
                        <div className="field col-6">
                            <label htmlFor="code">{t("documentStateCode")}</label>
                            <InputText id="code" value={item.code} onChange={(e) => onInputTextChange(e, 'code')}
                                       required autoFocus
                                       className={classNames({'p-invalid': submitted && !item.code})}/>
                            {submitted && !item.code && <small className="p-invalid">Code is required.</small>}
                        </div>
                        <div className="field col-6">
                            <label htmlFor="libelle">{t("documentStateLibelle")}</label>
                            <InputText id="libelle" value={item.libelle}
                                       onChange={(e) => onInputTextChange(e, 'libelle')} required autoFocus
                                       className={classNames({'p-invalid': submitted && !item.libelle})}/>
                            {submitted && !item.libelle && <small className="p-invalid">Libelle is required.</small>}
                        </div>
                        <div className="field col-6">
                            <label htmlFor="style">{t("documentStateStyle")}</label>
                            <InputText id="style" value={item.style} onChange={(e) => onInputTextChange(e, 'style')}
                                       required autoFocus
                                       className={classNames({'p-invalid': submitted && !item.style})}/>
                            {submitted && !item.style && <small className="p-invalid">Style is required.</small>}
                        </div>
                    </div>
                </TabPanel>
            </TabView>
        </Dialog>
    );
};
export default Create;
