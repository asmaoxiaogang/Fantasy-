package cn.aynuedu.user.pojo;


public class User {

  private long id;
  private String username;
  private String password;
  private String email;
  private String gender;
  private long flag;
  private long role;
  private String code;

  public User() {
  }

  public User(long id, String username, String password, String email, String gender, long flag, long role, String code) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.gender = gender;
    this.flag = flag;
    this.role = role;
    this.code = code;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", gender='" + gender + '\'' +
            ", flag=" + flag +
            ", role=" + role +
            ", code='" + code + '\'' +
            '}';
  }
}
