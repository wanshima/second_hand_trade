import { InfoCircleOutlined } from '@ant-design/icons';
import { Button, Card, Input, Form, InputNumber, Tooltip, TreeSelect } from 'antd';
import { connect, FormattedMessage, formatMessage } from 'umi';
import React, { useEffect } from 'react';
import { PageHeaderWrapper } from '@ant-design/pro-layout';
import styles from './style.less';

const FormItem = Form.Item;
const { TextArea } = Input;

const AddItemForm = props => {
  const { submitting } = props;
  const [form] = Form.useForm();
  const [, setShowPublicUsers] = React.useState(false);
  const formItemLayout = {
    labelCol: {
      xs: {
        span: 24,
      },
      sm: {
        span: 7,
      },
    },
    wrapperCol: {
      xs: {
        span: 24,
      },
      sm: {
        span: 12,
      },
      md: {
        span: 10,
      },
    },
  };
  const submitFormLayout = {
    wrapperCol: {
      xs: {
        span: 24,
        offset: 0,
      },
      sm: {
        span: 10,
        offset: 7,
      },
    },
  };

  useEffect(() => {
    const { dispatch } = props;
    if (dispatch) {
      dispatch(
        {
          type: 'squareAndAddItemForm/fetchCategories',
          payload: {},
        },
      );
    }
  }, []);

  const onFinish = values => {
    const { dispatch } = props;
    dispatch({
      type: 'squareAndAddItemForm/submitRegularForm',
      payload: values,
    });
  };

  const onFinishFailed = errorInfo => {
    // eslint-disable-next-line no-console
    console.log('Failed:', errorInfo);
  };

  const onValuesChange = changedValues => {
    const { publicType } = changedValues;
    if (publicType) setShowPublicUsers(publicType === '2');
  };

  return (
    <PageHeaderWrapper content={<FormattedMessage id="squareandadditemform.basic.description" />}>
      <Card bordered={false}>
        <Form
          hideRequiredMark
          style={{
            marginTop: 8,
          }}
          form={form}
          name="basic"
          initialValues={{
            public: '1',
          }}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          onValuesChange={onValuesChange}
        >
          <FormItem
            {...formItemLayout}
            label={<FormattedMessage id="squareandadditemform.category.label" />}
            name="categoryId"
            rules={[
              {
                required: true,
                message: formatMessage({
                  id: 'squareandadditemform.category.required',
                }),
              },
            ]}
          >
          <TreeSelect dropdownStyle={{ maxHeight: 400, overflow: 'auto' }} treeData={props.categories} placeholder={formatMessage({
              id: 'squareandadditemform.category.placeholder',
             })} />
          </FormItem>


          <FormItem
            {...formItemLayout}
            label={<FormattedMessage id="squareandadditemform.name.label" />}
            rules={[
              {
                required: true,
                message: formatMessage({
                  id: 'squareandadditemform.name.required',
                }),
              },
            ]}
            name="name"
          >
            <Input
              placeholder={formatMessage({
                id: 'squareandadditemform.name.placeholder',
              })}
            />
          </FormItem>
          
          <FormItem
            {...formItemLayout}
            label={<span>
              <FormattedMessage id="squareandadditemform.subtitle.label" />
              <em className={styles.optional}>
                <FormattedMessage id="squareandadditemform.form.optional" />
                <Tooltip title={<FormattedMessage id="squareandadditemform.label.tooltip" />}>
                  <InfoCircleOutlined
                    style={{
                      marginRight: 4,
                    }}
                  />
                </Tooltip>
              </em>
            </span>}
            name="subtitle"
          >
            <Input
              placeholder={formatMessage({
                id: 'squareandadditemform.subtitle.placeholder',
              })}
            />
          </FormItem>

          <FormItem
            {...formItemLayout}
            label={<span>
              <FormattedMessage id="squareandadditemform.mainImage.label" />
              <em className={styles.optional}>
                <FormattedMessage id="squareandadditemform.form.optional" />
                <Tooltip title={<FormattedMessage id="squareandadditemform.label.tooltip" />}>
                  <InfoCircleOutlined
                    style={{
                      marginRight: 4,
                    }}
                  />
                </Tooltip>
              </em>
            </span>}
            name="mainImage"
          >
            <Input
              placeholder={formatMessage({
                id: 'squareandadditemform.mainImage.placeholder',
              })}
            />
          </FormItem>

          <FormItem
            {...formItemLayout}
            label={<span>
              <FormattedMessage id="squareandadditemform.subImages.label" />
              <em className={styles.optional}>
                <FormattedMessage id="squareandadditemform.form.optional" />
                <Tooltip title={<FormattedMessage id="squareandadditemform.subImages.tooltip" />}>
                  <InfoCircleOutlined
                    style={{
                      marginRight: 4,
                    }}
                  />
                </Tooltip>
              </em>
            </span>}
            name="subImages"
          >
            <Input
              placeholder={formatMessage({
                id: 'squareandadditemform.subImages.placeholder',
              })}
            />
          </FormItem>

          <FormItem
            {...formItemLayout}
            label={<FormattedMessage id="squareandadditemform.detail.label" />}
            name="detail"
          >
            <TextArea
              style={{
                minHeight: 32,
              }}
              placeholder={formatMessage({
                id: 'squareandadditemform.detail.placeholder',
              })}
              rows={4}
            />
          </FormItem>

          <FormItem
            {...formItemLayout}
            label={<FormattedMessage id="squareandadditemform.price.label" />}
            rules={[
              {
                required: true,
                message: formatMessage({
                  id: 'squareandadditemform.price.required',
                }),
              },
            ]}
            name="price"
          >
            <InputNumber
              placeholder={formatMessage({
                id: 'squareandadditemform.price.placeholder',
              })}
              step={0.01}
              formatter={value => `$ ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ',')}
              parser={value => value.replace(/\$\s?|(,*)/g, '')}
            />
          </FormItem>

          <FormItem
            {...formItemLayout}
            label={<FormattedMessage id="squareandadditemform.stock.label" />}
            name="stock"
            rules={[
              {
                required: true,
                message: formatMessage({
                  id: 'squareandadditemform.stock.required',
                }),
              },
            ]}
          >
            <InputNumber
              placeholder={formatMessage({
                id: 'squareandadditemform.stock.placeholder',
              })}
              min={0}
              max={100}
            />
          </FormItem>
          
          <FormItem
            {...submitFormLayout}
            style={{
              marginTop: 32,
            }}
          >
            <Button type="primary" htmlType="submit" loading={submitting}>
              <FormattedMessage id="squareandadditemform.form.submit" />
            </Button>
            <Button
              style={{
                marginLeft: 8,
              }}
            >
              <FormattedMessage id="squareandadditemform.form.save" />
            </Button>
          </FormItem>
        </Form>
      </Card>
    </PageHeaderWrapper>
  );
};

export default connect(({ squareAndAddItemForm, loading }) => ({
  categories: squareAndAddItemForm.categories,
  submitting: loading.effects['squareAndAddItemForm/submitRegularForm'],
}))(AddItemForm);
