package com.example.order.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
//@Data
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(String goodsId) {
    this.goodsId = goodsId;
  }

  public String getAddressee() {
    return addressee;
  }

  public void setAddressee(String addressee) {
    this.addressee = addressee;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Short getStatus() {
    return status;
  }

  public void setStatus(Short status) {
    this.status = status;
  }

  public Short getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(Short payStatus) {
    this.payStatus = payStatus;
  }

  public Short getDeleteStatus() {
    return deleteStatus;
  }

  public void setDeleteStatus(Short deleteStatus) {
    this.deleteStatus = deleteStatus;
  }

  public String getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(String createUserId) {
    this.createUserId = createUserId;
  }

  public String getUpdateUserId() {
    return updateUserId;
  }

  public void setUpdateUserId(String updateUserId) {
    this.updateUserId = updateUserId;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }
}
