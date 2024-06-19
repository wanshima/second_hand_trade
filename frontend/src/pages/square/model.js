import { queryProductList, queryCategoryList } from './service';

const Model = {
  namespace: 'square',
  state: {
    products: [],
    categories: [],
  },
  effects: {
    *fetch({ payload }, { call, put }) {
      const response = yield call(queryProductList, payload);
      yield put({
        type: 'queryList',
        payload: Array.isArray(response) ? response : response.list,
      });
    },
    *fetchCategories({ payload }, { call, put }) {
      const response = yield call(queryCategoryList, payload);
      yield put({
        type: 'queryCategoryList',
        payload: Array.isArray(response) ? response : response.data,
      });
    },
  },
  reducers: {
    queryList(state, action) {
      return { ...state, products: action.payload };
    },
    queryCategoryList(state, action) {
      return { ...state, categories: action.payload };
    }
  },
};
export default Model;
