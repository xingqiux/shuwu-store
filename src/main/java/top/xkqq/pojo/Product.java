package top.xkqq.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product")
public class Product {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  private String name;
  private Double price;
  private Integer stock;
  private Integer categoryId;
  private Integer status;
  private String description;
  @TableField("img_url")
  private String imgUrl;

}
