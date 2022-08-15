import * as React from 'react';
import ReactDom from 'react-dom';
import App from './App';

/**
 * dayjs 설정
 */
import dayjs from 'dayjs';
import isLeapYear from 'dayjs/plugin/isLeapYear'; // 윤년 판단 플러그인
import 'dayjs/locale/ko'; // 한국어 가져오기

dayjs.extend(isLeapYear); // 플러그인 등록
dayjs.locale('ko'); // 언어 등록

/**
 * get object 추가
 */
import toObject from 'dayjs/plugin/toObject'; // 날짜 get object 플러그인
dayjs.extend(toObject); // 플러그인 등록



ReactDom.render(<App />, document.querySelector('#root'));