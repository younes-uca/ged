import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import AcessSharesList from 'app/component/admin/view/referetiel/acess-share/list/acess-share-list-admin.component';
import Layout from 'layout/layout';
import AuthGuard from 'app/component/auth/auth-guard.component';

const AcessShares: NextPageWithLayout = () => {
    return <AcessSharesList />
}

AcessShares.getLayout = function getLayout(page: ReactNode) {
    return (
    <AuthGuard>
        <Layout>
            {page}
        </Layout>
    </AuthGuard>
    )
}

export default AcessShares;
