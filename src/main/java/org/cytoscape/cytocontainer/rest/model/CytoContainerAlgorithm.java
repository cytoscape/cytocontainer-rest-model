package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Map;


/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerAlgorithm extends Algorithm {
    
   
    private String _dockerImage;
	private List<String> _hiddenParameters;
	private Map<String, String> _parameterFlagMap;
	


    @Schema(description="Container image")
    public String getDockerImage() {
        return _dockerImage;
    }

    public void setDockerImage(String dockerImage) {
        this._dockerImage = dockerImage;
    }

	@Schema(description="Hidden parameters")
	public List<String> getHiddenParameters() {
		return _hiddenParameters;
	}

	public void setHiddenParameters(List<String> hiddenParameters) {
		this._hiddenParameters = hiddenParameters;
	}

	public Map<String, String> getParameterFlagMap() {
		return _parameterFlagMap;
	}

	public void setParameterFlagMap(Map<String, String> _parameterFlagMap) {
		this._parameterFlagMap = _parameterFlagMap;
	}	
}
