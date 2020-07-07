package com.example.stock.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Stock {

  @Id
  @Column(columnDefinition = "char")
  private String id;
  @Column(columnDefinition = "char")
  private String goodsId;
  private Integer totalNum;
  private Integer surplusNum;
  @Column(columnDefinition = "tinyint")
  private Short status;
  @Column(columnDefinition = "tinyint")
  private Short deleteStatus;
  private String createUserId;
  private String updateUserId;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
