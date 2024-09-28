package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;


/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerAlgorithm extends Algorithm {
    
   
    private String dockerImage;
	private List<String> hiddenParameters;


    @Schema(description="Container image")
    public String getDockerImage() {
        return dockerImage;
    }

    public void setDockerImage(String dockerImage) {
        this.dockerImage = dockerImage;
    }

	
	public List<String> getHiddenParameters() {
		return hiddenParameters;
	}

	public void setHiddenParameters(List<String> hiddenParameters) {
		this.hiddenParameters = hiddenParameters;
	}
}
