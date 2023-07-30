import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import DocumentPartageUtilisateursList from 'app/component/admin/view/doc/document-partage-utilisateur/list/document-partage-utilisateur-list-admin.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const DocumentPartageUtilisateurs: NextPageWithLayout = () => {
    return <DocumentPartageUtilisateursList />
}

DocumentPartageUtilisateurs.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default DocumentPartageUtilisateurs;
