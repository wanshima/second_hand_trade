import { message } from 'antd';
import { submitAddItemForm } from './service';
import { queryCategoryList } from '../service';

const Model = {
  namespace: 'squareAndAddItemForm',
  state: {},
  effects: {
    *submitRegularForm({ payload }, { call }) {
      const response = yield call(submitAddItemForm, payload);
      message.success(response.msg);
    },
    *fetchCategories({ payload }, { call, put }) {
      const response = yield call(queryCategoryList, payload);
      console.log(response);
      yield put({
        type: 'processCategoryList',
        payload: Array.isArray(response) ? response : response.data,
      });
    },
  },
  reducers: {
    processCategoryList(state, action) {
      const categories = action.payload.map((cat) => {
        let jsonString = JSON.stringify(cat);
        jsonString = jsonString.replace(/categoryName/g, "title");
        jsonString = jsonString.replace(/categoryId/g, "value");
        jsonString = jsonString.replace(/subCategories/g, "children");
        return JSON.parse(jsonString);
      });
      return { ...state, categories };
    }
  }
};
export default Model;
