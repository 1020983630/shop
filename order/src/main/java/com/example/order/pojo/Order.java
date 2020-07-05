package com.example.order.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Order {

  @Id
  private String id;
  private String goodsId;
  private String addressee;
  private String mobile;
  private String address;
  private Short status;
  private Short payStatus;
  private Short deleteStatus;
  private String createUserId;
  private String updateUserId;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
