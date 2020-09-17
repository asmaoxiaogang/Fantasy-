package cn.aynuedu.pojo;


public class Orderdetail {

  private long id;
  private long pid;
  private String oid;
  private long num;
  private double money;

  public Orderdetail() {
  }

  public Orderdetail(long id, long pid, String oid, long num, double money) {
    this.id = id;
    this.pid = pid;
    this.oid = oid;
    this.num = num;
    this.money = money;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  public long getNum() {
    return num;
  }

  public void setNum(long num) {
    this.num = num;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "Orderdetail{" +
            "id=" + id +
            ", pid=" + pid +
            ", oid='" + oid + '\'' +
            ", num=" + num +
            ", money=" + money +
            '}';
  }
}
