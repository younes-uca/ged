import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import DocumentPartageGroupesList from 'app/component/admin/view/doc/document-partage-groupe/list/document-partage-groupe-list-admin.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const DocumentPartageGroupes: NextPageWithLayout = () => {
    return <DocumentPartageGroupesList />
}

DocumentPartageGroupes.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default DocumentPartageGroupes;
