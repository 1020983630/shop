package com.example.order.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class OrderForm {

  @Id
  @Column(columnDefinition = "char")
  private String id;
  @Column(columnDefinition = "char")
  private String goodsId;
  private String addressee;
  @Column(columnDefinition = "char")
  private String mobile;
  private String address;
  @Column(columnDefinition = "tinyint")
  private Short status;
  @Column(columnDefinition = "tinyint")
  private Short payStatus;
  @Column(columnDefinition = "tinyint")
  private Short deleteStatus;
  @Column(columnDefinition = "char")
  private String createUserId;
  @Column(columnDefinition = "char")
  private String updateUserId;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
