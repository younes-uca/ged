import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import DocumentTypesList from 'app/component/admin/view/doc/document-type/list/document-type-list-admin.component';
import Layout from 'layout/layout';

const DocumentTypes: NextPageWithLayout = () => {
    return <DocumentTypesList />
}

DocumentTypes.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default DocumentTypes;
