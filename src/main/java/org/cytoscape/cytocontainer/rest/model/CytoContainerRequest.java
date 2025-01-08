package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;

/**
 * Represents an Cytoscape Container REST Service Request
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerRequest {
    
    private JsonNode data;
    private Map<String, String> _parameters;

    /**
     * Gets data as string which should be in format of
     * SOURCENODE1\tTARGETNODE1\nSOURCENODE2\tTARGETNODE2\n
     * @return 
     */
    @Schema(description="data as json fragment")
    public JsonNode getData() {
        return data;
    }

    /**
     * Sets data as string which is json fragment format
     * @param data 
     */
    public void setData(JsonNode data) {
        this.data = data;
    }
    
    @Schema(description="Optional parameters in simple map format arg: value")
    public Map<String, String> getParameters() {
        return _parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        _parameters = parameters;
    }
}
