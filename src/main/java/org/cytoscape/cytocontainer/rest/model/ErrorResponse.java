package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Encapsulates an error encountered by the server
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    
    private String errorCode;
    private String message;
    private String description;
    private String stackTrace;
    private String threadId;
    private String timeStamp;
    
    public ErrorResponse(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("UTC"));
        timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm.s",
                                                 Locale.ENGLISH).format(ldt);
    }
	
	public ErrorResponse(final String message){
		this();
		this.message = message;
	}
    
    public ErrorResponse(final String message, Exception ex){
        this();
        this.message = message;
        description = ex.getMessage();
        StringBuilder stackTraceStr = new StringBuilder();
        int counter = 0;
        for (StackTraceElement ste : ex.getStackTrace()){
            stackTraceStr.append(ste.toString());
            if (counter >= 2){
                break;
            }
            counter++;
        }
        stackTrace = stackTraceStr.toString();
        threadId = Long.toString(Thread.currentThread().getId());
    }

    /**
     * Fallback implementation of json version of object
     * {"message":"hi",
     *  "stackTrace":"org.ndexbio.enri",
     *  "threadId":"1",
     *  "description":"well",
     *  "errorCode":null,
     *  "timeStamp":null}
     * @return 
     */
    public String asJson(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\"message\": ");
        sb.append(JsonUtil.getValueAsJsonString(getMessage()));
        sb.append(",\n");
        
        sb.append("\"stackTrace\": ");
        sb.append(JsonUtil.getValueAsJsonString(getStackTrace()));
        sb.append(",\n");

        sb.append("\"threadId\": ");
        sb.append(JsonUtil.getValueAsJsonString(getThreadId()));
        sb.append(",\n");

        sb.append("\"description\": ");
        sb.append(JsonUtil.getValueAsJsonString(getDescription()));
        sb.append(",\n");

        sb.append("\"errorCode\": ");
        sb.append(JsonUtil.getValueAsJsonString(getErrorCode()));
        sb.append(",\n");
        
        sb.append("\"timeStamp\": ");
        sb.append(JsonUtil.getValueAsJsonString(getTimeStamp()));
        sb.append("}");
        return sb.toString();
    }

    @Schema(description="Error code to help identify issue")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Schema(description="Human readable description of error")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Schema(description="More detailed description of error")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Schema(description="Stack trace of error")
    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Schema(description="Id of thread running process")
    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    @Schema(description="UTC Time stamp in YYYY-MM-DD_HH:MM.S")
    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    
}
