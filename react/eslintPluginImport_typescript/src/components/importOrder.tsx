// builtin
import path from 'path';
import fs from 'fs';

// external
import styled from 'styled-components';
import * as React from 'react';
import _ from 'lodash';

// parent
import Home from '../pages/home';

// sibling
import Ming from './ming';
import Baz from './Bars/baz';
import Bar from './bar';

// index
import importOrder from './';

// type
import type { FooProps } from '../foo';

// alias
import foo from '@/foo';

const ImportOrder = () => {
    return (
        <div>
            <h2>ImportOrder</h2>
        </div>
    );
};

export default ImportOrder;
