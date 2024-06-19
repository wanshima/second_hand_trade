import { queryItem } from './service';

const Model = {
  namespace: 'squareAndItemDetail',
  state:{
    product: null,
  },
  effects: {
    *fetchItemDetail(payload, {call, put}) {
      const response = yield call(queryItem, payload.payload.productId);
      yield put({
        type: 'queryDetail',
        payload: response,
      });
    },
  },
  reducers: {
    queryDetail(state={}, action) {
      return { ...state, product: action.payload };
    },
  },
};
export default Model;
