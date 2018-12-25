package netty.official;

/**
 * 自定义协议
 */
public class CustomData {

    /**
     * 协议头部
     */
    private CustomDataHead customDataHead;

    /**
     * 协议内容
     */
    private String content;

    public CustomData(CustomDataHead customDataHead, String content) {
        this.customDataHead = customDataHead;
        this.content = content;
    }

    public CustomDataHead getLuckHeader() {
        return customDataHead;
    }

    public void setLuckHeader(CustomDataHead customDataHead) {
        this.customDataHead = customDataHead;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("[version=%d,contentLength=%d,sessionId=%s,content=%s]",
                customDataHead.getVersion(),
                customDataHead.getContentLength(),
                customDataHead.getSessionId(),
                content);
    }
}
