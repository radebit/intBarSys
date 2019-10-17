package com.radebit.intbarsys.model.po;


public class Judgment {

  private Integer id;
  private String username;
  private String password;
  private String realName;
  private String idNumber;
  private java.sql.Timestamp regTime;
  private Integer state;
  private String smsNum;
  private Integer power;


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


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }


  public java.sql.Timestamp getRegTime() {
    return regTime;
  }

  public void setRegTime(java.sql.Timestamp regTime) {
    this.regTime = regTime;
  }


  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }


  public String getSmsNum() {
    return smsNum;
  }

  public void setSmsNum(String smsNum) {
    this.smsNum = smsNum;
  }


  public Integer getPower() {
    return power;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

}
