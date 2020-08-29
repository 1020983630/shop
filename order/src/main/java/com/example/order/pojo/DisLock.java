package com.example.order.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class DisLock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String resourceKey;
  private String resourceDesc;
  private LocalDateTime updateTime;

  public DisLock() {
  }

  public DisLock(String resourceKey, String resourceDesc) {
    this.resourceKey = resourceKey;
    this.resourceDesc = resourceDesc;
  }

}
