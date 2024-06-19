package com.esbteam.fleamarket.service.impl;

import com.esbteam.fleamarket.converter.Product2ProductDetailVo;
import com.esbteam.fleamarket.converter.Product2ProductVo;
import com.esbteam.fleamarket.converter.ProductCreateForm2Product;
import com.esbteam.fleamarket.dao.ProductMapper;
import com.esbteam.fleamarket.enums.ProductStatusEnum;
import com.esbteam.fleamarket.enums.ResponseEnum;
import com.esbteam.fleamarket.form.ProductCreateForm;
import com.esbteam.fleamarket.form.ProductUpdateForm;
import com.esbteam.fleamarket.pojo.Product;
import com.esbteam.fleamarket.pojo.UserInfo;
import com.esbteam.fleamarket.service.IProductService;
import com.esbteam.fleamarket.vo.ProductDetailVo;
import com.esbteam.fleamarket.vo.ProductVo;
import com.esbteam.fleamarket.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.esbteam.fleamarket.enums.ProductStatusEnum.DELETE;
import static com.esbteam.fleamarket.enums.ProductStatusEnum.OFF_SALE;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author hanjiabei
 * @Date 2020/7/12 7:17 下午
 **/
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Override
    public ResponseVo<PageInfo<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        if (categoryId != null){
            categoryService.findSubCategoryId(categoryId,categoryIdSet);
            categoryIdSet.add(categoryId);
        }

        PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> productVoList = productMapper.selectJoinUserByCategoryIdSet(categoryIdSet);
//        List<ProductVo> productVoList = productList.stream()
//                .map(Product2ProductVo::convert)
//                .collect(Collectors.toList());

        PageInfo<ProductVo> pageInfo = new PageInfo<>();
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetailVo> detail(String productId) {
        Product product = productMapper.selectByPrimaryKey(productId);

        //判断只对确定性的条件判断
        if (product.getStatus().equals(OFF_SALE.getCode()) || product.getStatus().equals(DELETE.getCode())){
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }
        ProductDetailVo productDetailVo = Product2ProductDetailVo.convert(product);
        //敏感数据处理
        productDetailVo.setStock(Math.max(100,productDetailVo.getStock()));
        return ResponseVo.success(productDetailVo);
    }

    @Override
    public ResponseVo<PageInfo<ProductVo>> listBySellerId(String sellerId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productMapper.selectBySellerId(sellerId);

        List<ProductVo> productVoList = productList.stream()
                .map(Product2ProductVo::convert)
                .collect(Collectors.toList());

        PageInfo<ProductVo> pageInfo = new PageInfo<>();
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetailVo> create(String userId, ProductCreateForm form) {
        //转化为Product
        Product product = ProductCreateForm2Product.convert(userId,form);
        product.setStatus(ProductStatusEnum.ON_SALE.getCode());

        //写入数据库
        int row = productMapper.insertSelective(product);
        if (row <= 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        //将信息传回前端
        ProductDetailVo productDetailVo = Product2ProductDetailVo.convert(product);
        return ResponseVo.success(productDetailVo);
    }

    @Override
    public ResponseVo update(String userId, String productId, ProductUpdateForm form) {
        //1, 查找productId相对应的Product
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        //2, 比对userId是否与product中的sellerId相匹配
        if (!product.getSellerId().equals(userId)) {
            //TODO 添加报警功能
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        //3, 更新Product的内容
        if (form.getCategoryId() != null) product.setCategoryId(form.getCategoryId());
        if (form.getName() != null) product.setName(form.getName());
        if (form.getSubtitle() != null) product.setSubImages(form.getSubtitle());
        if (form.getDetail() != null) product.setDetail(form.getDetail());
        if (form.getMainImage() != null) product.setMainImage(form.getMainImage());
        if (form.getSubImages() != null) product.setSubImages(form.getSubImages());
        if (form.getPrice() != null) product.setPrice(form.getPrice());
        if (form.getStock() != null) product.setStock(form.getStock());

        int row = productMapper.updateByPrimaryKeySelective(product);
        if (row <= 0) return ResponseVo.error(ResponseEnum.ERROR);

        return ResponseVo.success();
    }

}
