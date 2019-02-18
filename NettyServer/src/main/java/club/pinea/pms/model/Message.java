package club.pinea.pms.model;

public class Message {
    private Integer id;

    private Integer senderid;

    private Integer receiverid;

    private Boolean messagetype;

    private Long sendtime;

    private byte[] messagebody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public Boolean getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(Boolean messagetype) {
        this.messagetype = messagetype;
    }

    public Long getSendtime() {
        return sendtime;
    }

    public void setSendtime(Long sendtime) {
        this.sendtime = sendtime;
    }

    public byte[] getMessagebody() {
        return messagebody;
    }

    public void setMessagebody(byte[] messagebody) {
        this.messagebody = messagebody;
    }
}