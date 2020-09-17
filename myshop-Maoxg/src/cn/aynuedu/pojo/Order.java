package cn.aynuedu.pojo;


import java.sql.Timestamp;

public class Order {

  private String id;
  private long uid;
  private double money;
  private long status;
  private java.sql.Timestamp time;
  private long aid;

  public Order() {
  }

  public Order(String id, long uid, double money, long status, Timestamp time, long aid) {
    this.id = id;
    this.uid = uid;
    this.money = money;
    this.status = status;
    this.time = time;
    this.aid = aid;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public long getAid() {
    return aid;
  }

  public void setAid(long aid) {
    this.aid = aid;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id='" + id + '\'' +
            ", uid=" + uid +
            ", money=" + money +
            ", status=" + status +
            ", time=" + time +
            ", aid=" + aid +
            '}';
  }
}
