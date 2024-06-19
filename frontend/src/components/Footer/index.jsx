import React from 'react';
import { DefaultFooter } from '@ant-design/pro-layout';
import { GithubOutlined } from '@ant-design/icons';

const FleaMarketFooter = props => {
  const { className } = props;

  return (<DefaultFooter
    copyright="2020 UCSD Flea Market"
    links={[
      {
        key: 'github',
        title: <GithubOutlined />,
        href: 'https://github.com/Neo3333/flea_market',
        blankTarget: true,
      },
    ]}
  />);
};

export default FleaMarketFooter;
