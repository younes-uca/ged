import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import UtilisateursList from 'app/component/admin/view/user/utilisateur/list/utilisateur-list-admin.component';
import Layout from 'layout/layout';

const Utilisateurs: NextPageWithLayout = () => {
    return <UtilisateursList />
}

Utilisateurs.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default Utilisateurs;
