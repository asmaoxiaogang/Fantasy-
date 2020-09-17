package cn.aynuedu.pojo;


import java.sql.Date;

public class Goods {

  private long id;
  private String name;
  private java.sql.Date pubdate;
  private String picture;
  private long price;
  private long star;
  private String info;
  private long typeid;

  public Goods() {
  }

  public Goods(long id, String name, Date pubdate, String picture, long price, long star, String info, long typeid) {
    this.id = id;
    this.name = name;
    this.pubdate = pubdate;
    this.picture = picture;
    this.price = price;
    this.star = star;
    this.info = info;
    this.typeid = typeid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public java.sql.Date getPubdate() {
    return pubdate;
  }

  public void setPubdate(java.sql.Date pubdate) {
    this.pubdate = pubdate;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }


  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }


  public long getStar() {
    return star;
  }

  public void setStar(long star) {
    this.star = star;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }


  public long getTypeid() {
    return typeid;
  }

  public void setTypeid(long typeid) {
    this.typeid = typeid;
  }

  @Override
  public String toString() {
    return "Goods{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pubdate=" + pubdate +
            ", picture='" + picture + '\'' +
            ", price=" + price +
            ", star=" + star +
            ", info='" + info + '\'' +
            ", typeid=" + typeid +
            '}';
  }
}
