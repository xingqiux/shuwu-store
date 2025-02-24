package top.xkqq.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.xkqq.pojo.Product;
import top.xkqq.service.ProductService;
import top.xkqq.util.ResultUtil;
import top.xkqq.util.result.Result;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //分页查询商品
    @GetMapping
    //默认查询第一页10条数据
    public Result<Page<Product>> list(@RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "10")int size){
        Page<Product> products = new Page<>(page,size);
        productService.page(products);

        //测试是否正常返回数据
        System.out.println(products.getRecords());

        return ResultUtil.success(products);
    }

    //新增商品
//    @PostMapping
//    public

    //修改商品

    //逻辑删除商品


}
