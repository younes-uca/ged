/* eslint-disable @next/next/no-img-element */

import AppMenuitem from '/layout/AppMenuitem';
import {MenuProvider} from '/layout/context/menucontext';
import {AppMenuItem} from '/types/types';
import {AuthService} from 'app/zynerator/security/Auth.service';
import React, {useEffect, useState} from 'react';


const AppMenu = () => {

    const [model,setModel] = useState<AppMenuItem[]>([] as AppMenuItem[]);
    const authService = new AuthService();
        const modelAdmin: AppMenuItem[] = [
        {
            label: 'Home',
            items: [{label: 'Dashboard', icon: 'pi pi-fw pi-home', to: '/dashboard'}]
        },


        {
            label: 'Pages',
            icon: 'pi pi-fw pi-briefcase',
            to: '',
            items: [

                {
                    label: 'Auth',
                    icon: 'pi pi-fw pi-user',
                    items: [
                        {
                            label: 'Error',
                            icon: 'pi pi-fw pi-times-circle',
                            to: '/auth/error'
                        },
                        {
                            label: 'Access Denied',
                            icon: 'pi pi-fw pi-lock',
                            to: '/auth/access'
                        }
                    ]
                },
                {
                    label: 'Champs Document',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste document categorie field',
                     to: '/admin/view/fielddoc/document-categorie-field/list'
                      },
                      {
                      label: 'Liste document field state',
                     to: '/admin/view/fielddoc/document-field-state/list'
                      },
                      {
                      label: 'Liste document field',
                     to: '/admin/view/fielddoc/document-field/list'
                      },
                      {
                      label: 'Liste field',
                     to: '/admin/view/fielddoc/field/list'
                      },
                      {
                      label: 'Liste document categorie field rule',
                     to: '/admin/view/fielddoc/document-categorie-field-rule/list'
                      },
                    ]
                    },
                {
                    label: 'Referentiel Document',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste document type',
                     to: '/admin/view/refdoc/document-type/list'
                      },
                      {
                      label: 'Liste document state',
                     to: '/admin/view/refdoc/document-state/list'
                      },
                      {
                      label: 'Liste document categorie',
                     to: '/admin/view/refdoc/document-categorie/list'
                      },
                    ]
                    },
                {
                    label: 'Document Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste document partage utilisateur',
                     to: '/admin/view/doc/document-partage-utilisateur/list'
                      },
                      {
                      label: 'Liste document',
                     to: '/admin/view/doc/document/list'
                      },
                      {
                      label: 'Liste document partage groupe',
                     to: '/admin/view/doc/document-partage-groupe/list'
                      },
                    ]
                    },
                {
                    label: 'Organigramme Management',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste utilisateur',
                     to: '/admin/view/user/utilisateur/list'
                      },
                      {
                      label: 'Liste entite administrative type',
                     to: '/admin/view/doc/entite-administrative-type/list'
                      },
                      {
                      label: 'Liste entite administrative',
                     to: '/admin/view/user/entite-administrative/list'
                      },
                    ]
                    },
                {
                    label: 'Referentiel Partage',
                    icon: 'pi pi-fw pi-plus-circle',
                    items: [
                      {
                      label: 'Liste role utilisateur',
                     to: '/admin/view/refshare/role-utilisateur/list'
                      },
                      {
                      label: 'Liste etat utilisateur',
                     to: '/admin/view/refshare/etat-utilisateur/list'
                      },
                      {
                      label: 'Liste groupe',
                     to: '/admin/view/refshare/groupe/list'
                      },
                      {
                      label: 'Liste access share',
                     to: '/admin/view/refshare/access-share/list'
                      },
                    ]
                    },
            ]
        },

    ];
    const modelAgent: AppMenuItem[] = [
        {
            label: 'Home',
            items: [{label: 'Dashboard', icon: 'pi pi-fw pi-home', to: '/dashboard'}]
        },


        {
            label: 'Pages',
            icon: 'pi pi-fw pi-briefcase',
            to: '',
            items: [

                {
                    label: 'Auth',
                    icon: 'pi pi-fw pi-user',
                    items: [
                        {
                            label: 'Error',
                            icon: 'pi pi-fw pi-times-circle',
                            to: '/auth/error'
                        },
                        {
                            label: 'Access Denied',
                            icon: 'pi pi-fw pi-lock',
                            to: '/auth/access'
                        }
                    ]
                },
            ]
        },

    ];

    useEffect(()=>{
        const roleConnectedUser = authService.getRoleConnectedUser();
        if(roleConnectedUser === 'ROLE_ADMIN'){
            setModel(modelAdmin)
        }
        if(roleConnectedUser === 'ROLE_AGENT'){
            setModel(modelAgent)
        }
    },[])

    return (
        <MenuProvider>
            <ul className="layout-menu">
                {model.map((item, i) => {
                    return !item?.seperator ? <AppMenuitem item={item} root={true} index={i} key={item.label}/> :
                        <li className="menu-separator"></li>;
                })}


            </ul>
        </MenuProvider>
    );
};


export default AppMenu;
