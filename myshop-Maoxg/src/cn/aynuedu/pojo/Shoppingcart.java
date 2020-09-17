package cn.aynuedu.pojo;


public class Shoppingcart {

  private long id;
  private long pid;
  private long num;
  private long price;

  public Shoppingcart() {
  }

  public Shoppingcart(long id, long pid, long num, long price) {
    this.id = id;
    this.pid = pid;
    this.num = num;
    this.price = price;
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


  public long getNum() {
    return num;
  }

  public void setNum(long num) {
    this.num = num;
  }


  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Shoppingcart{" +
            "id=" + id +
            ", pid=" + pid +
            ", num=" + num +
            ", price=" + price +
            '}';
  }
}
