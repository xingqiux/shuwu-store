package top.xkqq.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import top.xkqq.mapper.ProductMapper;
import top.xkqq.pojo.Product;

@Component
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
