package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Contains result of invocation of algorithm
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerResult extends CytoContainerResultStatus {
    private JsonNode result;
 
    public CytoContainerResult(){
        super();
    }
    public CytoContainerResult(long startTime){
        super(startTime);
    }
    
    public CytoContainerResult updateStartTime(CytoContainerResult eqs) {
        super.updateStartTime(eqs);
        return this;
    }

    @Schema(description="Result of service in json fragment. The format should adhere to output denoted in serviceInputDefinition for service")
    public JsonNode getResult() {
        return result;
    }

    public void setResult(JsonNode result) {
        this.result = result;
    }
}
