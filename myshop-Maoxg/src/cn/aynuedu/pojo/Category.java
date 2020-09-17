package cn.aynuedu.pojo;


public class Category {

  private long id;
  private String name;
  private long level;
  private long parent;

  public Category() {
  }

  public Category(long id, String name, long level, long parent) {
    this.id = id;
    this.name = name;
    this.level = level;
    this.parent = parent;
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


  public long getLevel() {
    return level;
  }

  public void setLevel(long level) {
    this.level = level;
  }


  public long getParent() {
    return parent;
  }

  public void setParent(long parent) {
    this.parent = parent;
  }

  @Override
  public String toString() {
    return "Category{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", level=" + level +
            ", parent=" + parent +
            '}';
  }
}
