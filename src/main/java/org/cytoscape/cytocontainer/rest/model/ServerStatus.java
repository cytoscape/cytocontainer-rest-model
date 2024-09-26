package org.cytoscape.cytocontainer.rest.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

/**
 * Represents status of the server
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerStatus {
    
    
    public static final String OK_STATUS = "ok";
    public static final String ERROR_STATUS = "error";
    
    private String status;
    private int pcDiskFull;
    private List<Float> load;
    private int queuedTasks;
    private int completedTasks;
    private int canceledTasks;
    private String version;
    

    public ServerStatus(){
    }

    /**
     * Gets status of server which can be either {@link #OK_STATUS} or
     * {@link #ERROR_STATUS}
     * @return Status as a string
     */
    @Schema(description="Status of server", allowableValues={ServerStatus.OK_STATUS,
                                                             ServerStatus.ERROR_STATUS})
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Schema(description="Gets how full disk is as a percentage 0 - 100")
    public int getPcDiskFull() {
        return pcDiskFull;
    }

    public void setPcDiskFull(int pcDiskFull) {
        this.pcDiskFull = pcDiskFull;
    }

    @Schema(description="List of 3 floats containing 1 minute, 5 minute, 15minute load")
    public List<Float> getLoad() {
        return load;
    }

    public void setLoad(List<Float> load) {
        this.load = load;
    }

   
    @Schema(description="Gets version of this service")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }    

    @Schema(description="Gets number of currently queued/running tasks")
    public int getQueuedTasks() {
        return queuedTasks;
    }

    public void setQueuedTasks(int queuedTasks) {
        this.queuedTasks = queuedTasks;
    }

    @Schema(description="Gets number of completed tasks since last restart of this service")
    public int getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(int completedTasks) {
        this.completedTasks = completedTasks;
    }

    @Schema(description="Gets number of canceled tasks since last restart of this service")
    public int getCanceledTasks() {
        return canceledTasks;
    }

    public void setCanceledTasks(int canceledTasks) {
        this.canceledTasks = canceledTasks;
    }
}
