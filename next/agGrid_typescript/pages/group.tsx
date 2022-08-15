import * as React from 'react';
import { NextPage } from 'next';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import 'ag-grid-enterprise'; // enterprise import
import { AgGridReact } from 'ag-grid-react';

interface IrowData {
    brand: string;
    name: string;
    capacity: number;
    price: number;
}

const Group: NextPage = () => {

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
        { field: 'brand', rowGroup: true, hide: true }, // brand를 기준으로 그룹화
        { field: 'name', /* rowGroup: true, hide: true */ }, // group 기준 필드를 늘리고 싶은 경우 주석 해제
        { field: 'capacity' },
        { field: 'price' },
    ])

    // 그룹화된 컬럼 설정
    const autoGroupColumnDef = React.useMemo(() => {
        return {
            resizable: true,
        }
    }, [])

    return (
        <div className="ag-theme-alpine" style={{ width: 600, height: 400, margin: '0 auto' }}>
            {/* Grid에 그룹 컬럼 설정 추가 */}
            <AgGridReact
                rowData={rowData}
                columnDefs={columnDefs}
                autoGroupColumnDef={autoGroupColumnDef}>
            </AgGridReact>
        </div>
    );
};

export default Group;