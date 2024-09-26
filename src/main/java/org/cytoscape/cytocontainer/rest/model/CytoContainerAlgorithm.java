package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerAlgorithm {
    
    private String name;
    private String displayName;
    private String description;
    private String version;
    private String dockerImage;
    private String inputDataFormat;
    private String outputDataFormat;
	private String rawResultContentType;
	private boolean binaryResult;
	
    private HashMap<String, Parameter> customParameters;
    
    @Schema(description="Name of algorithm")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Schema(description="Display name of algorithm")
    public String getDisplayName() {
	return displayName;
    }

    public void setDisplayName(String displayName) {
	this.displayName = displayName;
    }

    @Schema(description="Description of algorithm")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Schema(description="Version of algorithm")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Schema(description="Docker image")
    public String getDockerImage() {
        return dockerImage;
    }

    public void setDockerImage(String dockerImage) {
        this.dockerImage = dockerImage;
    }

    @Schema(description="Expected format of input data. For supported formats see: "
            + " https://github.com/cytoscape/communitydetection-rest-server/wiki/Data-formats\n")
    public String getInputDataFormat() {
        return inputDataFormat;
    }

    public void setInputDataFormat(String inputDataFormat) {
        this.inputDataFormat = inputDataFormat;
    }

    @Schema(description="Format of output data. For supported formats see: "
            + " https://github.com/cytoscape/communitydetection-rest-server/wiki/Data-formats\n")
    public String getOutputDataFormat() {
        return outputDataFormat;
    }

    public void setOutputDataFormat(String outputDataFormat) {
        this.outputDataFormat = outputDataFormat;
    }

    @Schema(description="Any custom parameters this algorithm accepts")
    public Set<Parameter> getCustomParameters() {
        if (customParameters == null){
            return null;
        }
        return new HashSet(customParameters.values());
    }

	public String getRawResultContentType() {
		return rawResultContentType;
	}

	public void setRawResultContentType(String rawResultContentType) {
		this.rawResultContentType = rawResultContentType;
	}

	public boolean isBinaryResult() {
		return binaryResult;
	}

	public void setBinaryResult(boolean binaryResult) {
		this.binaryResult = binaryResult;
	}

    public void setCustomParameters(Set<Parameter> customParameters) {
        if (customParameters == null){
            this.customParameters = null;
            return;
        }
        if (this.customParameters == null){
            this.customParameters = new HashMap<>();
        }else {
            this.customParameters.clear();
        }
        for (Parameter cp : customParameters){
            if (cp.getName() == null){
                continue;
            }
            this.customParameters.put(cp.getName(), cp);
        }
    }
    
    @JsonIgnore
    public Map<String, Parameter> getCustomParameterMap(){
        return this.customParameters;
    }
}
