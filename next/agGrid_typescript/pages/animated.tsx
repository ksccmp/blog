import * as React from 'react';
import { NextPage } from 'next';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import 'ag-grid-enterprise';
import { AgGridReact } from 'ag-grid-react';

interface IrowData {
    brand: string;
    name: string;
    capacity: number;
    price: number;
}

const Animated: NextPage = () => {

    const [rowData] = React.useState<IrowData[]>([
        { brand: '칠성', name: '사이다', capacity: 500, price: 2000 },
        { brand: '칠성', name: '사이다', capacity: 1000, price: 3000 },
        { brand: '칠성', name: '제로사이다', capacity: 360, price: 1000 },
        { brand: '펩시', name: '콜라', capacity: 500, price: 1500 },
        { brand: '펩시', name: '제로콜라', capacity: 500, price: 1500 },
        { brand: '코카콜라', name: '콜라', capacity: 500, price: 1800 },
        { brand: '코카콜라', name: '제로콜라', capacity: 500, price: 2000 },
        { brand: '해태', name: '갈아만든배', capacity: 360, price: 1500 },
    ])

    const [columnDefs] = React.useState([
        { field: 'brand', rowGroup: true, hide: true },
        { field: 'name' },
        { field: 'capacity' },
        { field: 'price' },
    ])

    const autoGroupColumnDef = React.useMemo(() => {
        return {
            resizable: true,
        }
    }, [])

    return (
        <div className="ag-theme-alpine" style={{ width: 600, height: 400, margin: '0 auto' }}>
            {/* 애니메이션 설정 추가 */}
            <AgGridReact
                rowData={rowData}
                columnDefs={columnDefs}
                autoGroupColumnDef={autoGroupColumnDef}
                animateRows={true}>
            </AgGridReact>
        </div>
    );
};

export default Animated;