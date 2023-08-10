import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import DocumentIndexElementStatesList from 'app/component/admin/view/referentiel-doc/document-index-element-state/list/document-index-element-state-list-admin.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const DocumentIndexElementStates: NextPageWithLayout = () => {
    return <DocumentIndexElementStatesList />
}

DocumentIndexElementStates.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default DocumentIndexElementStates;
