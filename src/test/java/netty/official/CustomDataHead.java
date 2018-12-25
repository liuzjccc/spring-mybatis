package netty.official;

/**
 * 自定义协议头部
 */
public class CustomDataHead {

    /**
     * 协议版本
     */
    private int version;

    /**
     * 消息内容长度
     */
    private int contentLength;

    /**
     * sessionId
     */
    private String sessionId;

    public CustomDataHead(int version, int contentLength, String sessionId) {
        this.version = version;
        this.contentLength = contentLength;
        this.sessionId = sessionId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
