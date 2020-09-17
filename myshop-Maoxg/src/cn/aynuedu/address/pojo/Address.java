package cn.aynuedu.address.pojo;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:32
 */

public class Address {

    private long id;
    private String detail;
    private String name;
    private String phone;
    private long uid;
    private long level;

    public Address() {
    }

    public Address(long id, String detail, String name, String phone, long uid, long level) {
        this.id = id;
        this.detail = detail;
        this.name = name;
        this.phone = phone;
        this.uid = uid;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }


    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", uid=" + uid +
                ", level=" + level +
                '}';
    }
}
