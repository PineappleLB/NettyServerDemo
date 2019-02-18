package club.pinea.pms.model;

public class User {
    private Integer id;

    private String username;

    private String nickname;

    private String phoneno;

    private String password;

    private String solt;

    private Boolean status;

    private String lastloginip;

    private Long lastlogintime;

    private Long createtime;

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
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno == null ? null : phoneno.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSolt() {
        return solt;
    }

    public void setSolt(String solt) {
        this.solt = solt == null ? null : solt.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    public Long getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Long lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}