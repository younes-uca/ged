import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import DocumentFieldsList from 'app/component/admin/view/doc/document-field/list/document-field-list-admin.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const DocumentFields: NextPageWithLayout = () => {
    return <DocumentFieldsList />
}

DocumentFields.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default DocumentFields;
