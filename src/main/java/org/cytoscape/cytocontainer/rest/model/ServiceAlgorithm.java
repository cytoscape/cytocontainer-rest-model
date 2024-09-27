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
public class ServiceAlgorithm {
    
    private String name;
    private String displayName;
    private String description;
    private String version;
	
    private HashMap<String, Parameter> _parameters;
    
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
	
	@Schema(description="Any custom parameters this algorithm accepts")
    public Set<Parameter> getParameters() {
        if (_parameters == null){
            return null;
        }
        return new HashSet(_parameters.values());
    }

    public void setParameters(Set<Parameter> parameters) {
        if (parameters == null){
            this._parameters = null;
            return;
        }
        if (this._parameters == null){
            this._parameters = new HashMap<>();
        }else {
            this._parameters.clear();
        }
        for (Parameter cp : parameters){
            if (cp.getName()== null){
                continue;
            }
            this._parameters.put(cp.getName(), cp);
        }
    }
    
    @JsonIgnore
    public Map<String, Parameter> getParameterMap(){
        return this._parameters;
    }

    
}
