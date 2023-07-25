import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import DocumentsList from '../../../../../../app/component/admin/view/doc/document/list/document-list-admin.component';
import Layout from '../../../../../../layout/layout';

const Documents: NextPageWithLayout = () => {
    return <DocumentsList />
}

Documents.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default Documents;
