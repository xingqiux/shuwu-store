package top.xkqq.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.xkqq.pojo.Product;
import top.xkqq.service.ProductService;
import top.xkqq.util.ResultUtil;
import top.xkqq.util.result.Result;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("recommended/{type}")
    /**
     * 功能：获取系统推荐的商品列表
     *
     * 参数：
     * type : 用于细分推荐类型的数值
     * userId（可选）：当前用户ID，用于个性化推荐
     * page：页码，默认为1
     * size：每页数量，默认为8
     * categoryId（可选）：分类ID，可以按分类筛选推荐商品
     * 返回：包含推荐商品列表的JSON对象，包括商品ID、名称、价格、图片URL、评分等信息
     *
     * 备注：这个接口实现的是主页推荐商品的列表的功能和按类型推荐的功能
     */
    public Result<Page<Product>> recommended(@RequestParam(defaultValue ="1") int userId,
                                             @RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "8")int size,
                                             @RequestParam(defaultValue ="0") int categoryId,
                                             @PathVariable String type){
        switch (type){
            case "new":
                // 返回成功并分页查询 1,8,与接收到的 categoryId
                return ResultUtil.success(productService.page(new Page<>(page, size, categoryId)));
            default:
                return ResultUtil.success(productService.page(new Page<>(page, size)));
        }
    }


    @GetMapping("product/{id}")
    /**
     * GET /product/{id}
     * 这是单个商品详情接口，与前两个接口不同，它不是用于获取商品列表，而
     * 是当用户点击某个推荐商品后，跳转到商品详情页面时使用的接口。
     */
    public Result<Product> productResult(@PathVariable int id){

        Product product = productService.getById(id);

        if(product == null){
            return ResultUtil.fail("不存在当前商品");
        }
        System.out.println(product);
        return ResultUtil.success(product);
    }
}
