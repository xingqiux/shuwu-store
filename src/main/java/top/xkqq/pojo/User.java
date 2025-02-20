package top.xkqq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {

  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;
  private String username;
  private String password;
  private String email;

  @TableField(exist = false)
  private String Token;

  @TableField("created_at")
  private LocalDateTime createdAt;

}
