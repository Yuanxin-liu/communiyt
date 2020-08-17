package com.community.community.bean;

//申请表实体
public class Application {
    private int id;  //申请表id
    private int rid;  //居民id
    private String out_time;  //申请外出时间
    private String in_time;   //申请回社区时间
    private String actual_out_time;  //实际外出时间
    private String actual_in_time;   //实际回到社区时间
    private String reason;          //申请外出原因
    private String temperature;     //申请人当日体温
    private int statu;             //申请表状态
    private String username;       //申请人姓名
    private String password;       //申请人登录密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getActual_out_time() {
        return actual_out_time;
    }

    public void setActual_out_time(String actual_out_time) {
        this.actual_out_time = actual_out_time;
    }

    public String getActual_in_time() {
        return actual_in_time;
    }

    public void setActual_in_time(String actual_in_time) {
        this.actual_in_time = actual_in_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
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

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", rid=" + rid +
                ", out_time='" + out_time + '\'' +
                ", in_time='" + in_time + '\'' +
                ", actual_out_time='" + actual_out_time + '\'' +
                ", actual_in_time='" + actual_in_time + '\'' +
                ", reason='" + reason + '\'' +
                ", temperature='" + temperature + '\'' +
                ", statu=" + statu +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
