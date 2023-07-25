import {NextPageWithLayout} from 'next';
import {ReactNode} from 'react';

import TagsList from '../../../../../../app/component/admin/view/doc/tag/list/tag-list-admin.component';
import Layout from '../../../../../../layout/layout';

const Tags: NextPageWithLayout = () => {
    return <TagsList />
}

Tags.getLayout = function getLayout(page: ReactNode) {
    return (
        <Layout>
            {page}
        </Layout>
    )
}

export default Tags;
