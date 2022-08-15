import * as React from 'react';
import { NextPage } from 'next';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import { AgGridReact } from 'ag-grid-react';

interface IrowData {
    brand: string;
    name: string;
    capacity: number;
    price: number;
}

const SortingFilter: NextPage = () => {

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

    // 정렬 및 필터 설정
    const [columnDefs] = React.useState([
        { field: 'brand', sortable: true, filter: true },
        { field: 'name', sortable: true, filter: true },
        { field: 'capacity', sortable: true, filter: true },
        { field: 'price', sortable: true, filter: true },
    ])

    return (
        <div className="ag-theme-alpine" style={{ width: 600, height: 400, margin: '0 auto' }}>
            <AgGridReact
                rowData={rowData}
                columnDefs={columnDefs}>
            </AgGridReact>
        </div>
    );
};

export default SortingFilter;