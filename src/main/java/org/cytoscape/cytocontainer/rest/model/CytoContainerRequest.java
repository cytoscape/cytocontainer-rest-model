package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;

/**
 * Represents an Community Detection Request
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerRequest {
    
    private String algorithm;
    private JsonNode data;
    private Map<String, String> customParameters;

    /**
     * Gets the name of the algorithm to use with this request
     * @return 
     */
    @Schema(description="Name of algorithm to run", example="louvain")
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the name of the algorithm to use with this request
     * @param _algorithm 
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

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
    
    @Schema(description="Optional custom parameters in simple map format arg: value")
    public Map<String, String> getCustomParameters() {
        return customParameters;
    }

    public void setCustomParameters(Map<String, String> customParameters) {
        this.customParameters = customParameters;
    }
}
