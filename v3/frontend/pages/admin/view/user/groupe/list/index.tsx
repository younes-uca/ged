import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import GroupesList from 'app/component/admin/view/user/groupe/list/groupe-list-admin.component';
import Layout from 'layout/layout';

const Groupes: NextPageWithLayout = () => {
    return <GroupesList />
}

Groupes.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default Groupes;
