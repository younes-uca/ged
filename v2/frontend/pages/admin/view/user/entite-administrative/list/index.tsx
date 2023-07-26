import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import EntiteAdministrativesList from 'app/component/admin/view/user/entite-administrative/list/entite-administrative-list-admin.component';
import Layout from 'layout/layout';

const EntiteAdministratives: NextPageWithLayout = () => {
    return <EntiteAdministrativesList />
}

EntiteAdministratives.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default EntiteAdministratives;
