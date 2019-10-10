package com.radebit.intbarsys.model.po;


import java.io.Serializable;

public class Admin implements Serializable {

  private Integer id;
  private String username;
  private String password;
  private java.sql.Timestamp lastLoginTime;
  private String lastLoginIp;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public java.sql.Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(java.sql.Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public String getLastLoginIp() {
    return lastLoginIp;
  }

  public void setLastLoginIp(String lastLoginIp) {
    this.lastLoginIp = lastLoginIp;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", lastLoginTime=" + lastLoginTime +
            ", lastLoginIp='" + lastLoginIp + '\'' +
            '}';
  }
}
