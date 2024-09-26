package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerResultStatus extends JobStatus {
    
    private String id;
    private String status;
    private String message;
    private int progress;
    private long wallTime;
    private long startTime;
    
    public CytoContainerResultStatus(){
        
    }
    
    /**
     * Creates new {@link #CommunityDetectionRequestStatus} object setting {@link #getStartTime() }
     * to {@code startTime} passed into this method.
     * @param startTime Current time in milliseconds, usually set with value from {@link java.lang.System.currentTimeMillis()}
     */
    public CytoContainerResultStatus(long startTime){
        this.startTime = startTime;
    }
    
    /**
     * Creates new {@link #EnrichmentQueryStatus} by copying data
     * from {@code cdr} passed in
     * @param cdr {@link org.cytoscape.cytocontainer.rest.model.CytoContainerResult} to copy from
     */
    public CytoContainerResultStatus(CytoContainerResult cdr){
        if (cdr == null){
            return;
        }
        id = cdr.getId();
        status = cdr.getStatus();
        message = cdr.getMessage();
        progress = cdr.getProgress();
        wallTime = cdr.getWallTime();
        startTime = cdr.getStartTime();
    }
 
    /**
     * Updates start time with value from {@code cdrs} passed in if that
     * time is greater then the time in this object.
     * @param cdrs
     * @return Returns this object
     */
    public CytoContainerResultStatus updateStartTime(CytoContainerResultStatus cdrs){
        if (cdrs == null){
            return this;
        }
        if (cdrs.getStartTime() > startTime){
            startTime = cdrs.getStartTime();
        }
        return this;
    }

    @Schema(description="Id of Community Detection Request", example="261fb9b7-75af-4f1a-9caa-e57a4b5fc349")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Schema(description="Status of task can be (" + COMMA_DELIM_STATUS + ")", example=SUBMITTED_STATUS)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Schema(description="null or a message denoting a possible issue")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Schema(description="int between 0 and 100 denoting progress of task")
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Schema(description="Walltime in milliseconds task took to run")
    public long getWallTime() {
        return wallTime;
    }

    public void setWallTime(long wallTime) {
        this.wallTime = wallTime;
    }

    @Schema(description="Time in milliseconds since 1969 epoch when task started")
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
