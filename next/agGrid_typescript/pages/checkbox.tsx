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

const CheckBox: NextPage = () => {

    const agGridReactRef = React.useRef<AgGridReact>(null); // agGridReact useRef

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
        { field: 'brand', checkboxSelection: true }, // brand에 checkbox 추가
        { field: 'name' },
        { field: 'capacity' },
        { field: 'price' },
    ])

    // 선택된 데이터 확인
    const handleSelected = () => {
        if(agGridReactRef.current) {
            const selectedNodes = agGridReactRef.current.api.getSelectedNodes();
            const selectedData = selectedNodes.map((node) => node.data);
            console.log(selectedData);
        }
    }

    return (
        <div className="ag-theme-alpine" style={{ width: 600, height: 400, margin: '0 auto' }}>
            {/* 체크박스 다중 선택 설정 */}
            <AgGridReact
                ref={agGridReactRef}
                rowData={rowData}
                columnDefs={columnDefs}
                rowSelection="multiple">
            </AgGridReact>

            <button onClick={handleSelected}>Click !</button> {/* 버튼 클릭 시 선택된 데이터 확인 */}
        </div>
    );
};

export default CheckBox;