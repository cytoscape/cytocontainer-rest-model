package org.cytoscape.cytocontainer.rest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Set;


/**
 * Server Meta data
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceMetaData {
	private String _name;
	private String _description;
	private String _version;
	private String _rootMenu;
	private ServiceAlgorithm _algorithm;

	@Schema(description="Name of Service App")
	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	@Schema(description="Service App description")
	public String getDescription() {
		return _description;
	}

	public void setDescription(String _description) {
		this._description = _description;
	}

	@JsonIgnore
	public ServiceAlgorithm getAlgorithm() {
		return _algorithm;
	}

	public void setAlgorithm(ServiceAlgorithm algorithm) {
		this._algorithm = algorithm;
	}

	@Schema(description="Desired name and location of this service side app in Cytoscape on the Web Menu system. For more information see: "
            + " https://github.com/cytoscape-web\n")
	public String getRootMenu() {
		return _rootMenu;
	}

	public void setRootMenu(String _rootMenu) {
		this._rootMenu = _rootMenu;
	}
	
	@Schema(description="Any custom parameters service accepts")
    public Set<Parameter> getParameters() {
        if (_algorithm == null || _algorithm.getParameters() == null){
            return null;
        }
        return _algorithm.getParameters();
    }

}
