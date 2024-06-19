import { Card, Form, List, Typography, Input, Button } from 'antd';
import React, { useEffect, useState } from 'react';
import { PageHeaderWrapper } from '@ant-design/pro-layout';
import { connect, formatMessage, Link } from 'umi';
import moment from 'moment';
import AvatarList from './components/AvatarList';
import StandardFormRow from './components/StandardFormRow';
import TagSelect from './components/TagSelect';
import styles from './style.less';

const FormItem = Form.Item;
const { Paragraph } = Typography;

const getKey = (id, index) => `${id}-${index}`;

const Square = ({ dispatch, square: { products = [], categories = [] }, loading }) => {
  useEffect(() => {
    dispatch(
      {
        type: 'square/fetchCategories',
        payload: {},
      },
    );
    dispatch(
      {
        type: 'square/fetch',
        payload: {},
      }
    );
  }, []);

  const [selectedCategory] = useState([]);

  const cardList = products && (
    <List
      rowKey="id"
      loading={loading}
      grid={{
        gutter: 16,
        xs: 1,
        sm: 2,
        md: 3,
        lg: 3,
        xl: 4,
        xxl: 4,
      }}
      dataSource={products}
      renderItem={item => (
        <List.Item>
          <Card className={styles.card} hoverable cover={<img alt={item.name} src={item.mainImage} />}>
          <Link to={`/square/detail/${item.productId}`}>
            <Card.Meta
              title={<a>{item.name}</a>}
              description={
                <Paragraph
                  className={styles.item}
                  ellipsis={{
                    rows: 2,
                  }}
                >
                  {item.substitle}
                </Paragraph>
              }
            />
          </Link>
            <div className={styles.cardItemContent}>
              <span>{moment(item.updateTime).fromNow()}</span>
              <div className={styles.avatarList}>
                <AvatarList size="small">
                    <AvatarList.Item
                      key={getKey(item.productId, 0)}
                      src={item.member.userIcon}
                      tips={item.member.username}
                    />
                </AvatarList>
              </div>
            </div>
          </Card>
        </List.Item>
      )}
    />
  );

  const handleFormSubmit = value => {
    // eslint-disable-next-line no-console
    console.log(value);
  };

  const pageHeaderContent = (
    <div
      style={{
        display: 'inline-block',
      }}
    >
      
      <Input.Search
        placeholder="请输入"
        enterButton="搜索"
        size="large"
        onSearch={handleFormSubmit}
        style={{
          maxWidth: 522,
          width: '500px',
          display: 'inline-block',
          float: 'left'
        }}
      />
      <Button type="primary" size="large" style={{
          position:'absolute',
          right:'2%',
          display:'inline-block',
          float:'left',
      }}>
        <Link to="/square/additem">添加商品</Link>
      </Button>
    </div>
  );

  return (
    <PageHeaderWrapper
        content={pageHeaderContent}
      >
    <div className={styles.coverCardList}>
      <Card bordered={false}>
        <Form
          layout="inline"
          onValuesChange={(selectedCategory) => {
            // 表单项变化时请求数据
            // 模拟查询表单生效
            dispatch({
              type: 'square/fetch',
              payload: {
                categoryId: selectedCategory.category[0],
              },
            });
          }}
        >
          <StandardFormRow
            title={formatMessage({
              id: 'square.type',
            })}
            block
            style={{
              paddingBottom: 11,
            }}
          >
            <FormItem name="category">
              <TagSelect expandable value={selectedCategory}>
              {categories.map(category => (
                <TagSelect.Option key={category.categoryId} value={category.categoryId}>{category.categoryName}</TagSelect.Option>
              ))}
              </TagSelect>
            </FormItem>
          </StandardFormRow>
        </Form>
      </Card>
      <div className={styles.cardList}>{cardList}</div>
    </div>
    </PageHeaderWrapper>
  );
};

export default connect(({ square, loading }) => ({
  square,
  loading: loading.models.square,
}))(Square);
