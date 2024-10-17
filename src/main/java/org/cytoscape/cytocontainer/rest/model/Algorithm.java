package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.cytoscape.cytocontainer.rest.model.exceptions.CytoContainerException;

/**
 * Algorithm that performs some operation for a service
 * 
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Algorithm {
	
	public static final String ADD_NETWORKS_ACTION = "addNetworks";
	public static final String ADD_TABLES_ACTION = "addTables";
	public static final String UPDATE_NETWORK_ACTION = "updateNetwork";
	public static final String UPDATE_TABLES_ACTION = "updateTables";
	public static final String UPDATE_LAYOUTS_ACTION = "updateLayouts";
	public static final String UPDATE_SELECTION_ACTION = "updateSelection";
	public static final Set<String> ACTION_SET = Set.of(ADD_NETWORKS_ACTION, ADD_TABLES_ACTION,
			UPDATE_NETWORK_ACTION, UPDATE_TABLES_ACTION, UPDATE_LAYOUTS_ACTION, UPDATE_SELECTION_ACTION);
    private String _name;
    private String _description;
    private String _version;
	private List<String> _cyWebActions;
	private String _author;
	private String _citation;
	private ServiceInputDefinition _serviceInputDefinition;
	private CyWebMenuItem _cyWebMenuItem;
	protected HashMap<String, AlgorithmParameter> _parameters;

	public Algorithm(){
		
	}
	
	public Algorithm(Algorithm algorithm){
		if (algorithm == null){
			return;
		}
		_name = algorithm.getName();
		_description = algorithm.getDescription();
		_version = algorithm.getVersion();
		if (algorithm.getCyWebActions() != null){
			_cyWebActions = new ArrayList<>();
			_cyWebActions.addAll(algorithm.getCyWebActions());
			
		}
		_cyWebMenuItem = algorithm.getCyWebMenuItem();
		_author = algorithm.getAuthor();
		_citation = algorithm.getCitation();
		
		if (algorithm.getParameterMap() != null){
			for (String key : algorithm.getParameterMap().keySet()){
				addParameter(new AlgorithmParameter(algorithm.getParameterMap().get(key)));
			}
		}
		if (algorithm.getServiceInputDefinition() != null){
			_serviceInputDefinition = new ServiceInputDefinition(algorithm.getServiceInputDefinition());
		}
	}
	
	@Schema(description="Desired name and location of this service side app in Cytoscape on the Web Menu system. For more information see: "
							+ " https://github.com/cytoscape-web\n")
    public CyWebMenuItem getCyWebMenuItem() {
		return _cyWebMenuItem;
	}

	public void setCyWebMenuItem(CyWebMenuItem _cyWebMenuItem) {
		this._cyWebMenuItem = _cyWebMenuItem;
	}
    
    @Schema(description="Name of algorithm")
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    @Schema(description="Description of algorithm")
    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    @Schema(description="Version of algorithm")
    public String getVersion() {
        return _version;
    }

    public void setVersion(String version) {
        this._version = version;
    }

	@Schema(description="Author(s) of this service")
	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		this._author = author;
	}

	@Schema(description="Citation for this service")
	public String getCitation() {
		return _citation;
	}

	public void setCitation(String citation) {
		this._citation = citation;
	}
	
	

	@Schema(description="List of action to be performed with result by caller. Elements of list can "
			+ "be one of the allowable values",
			allowableValues = {Algorithm.ADD_NETWORKS_ACTION,
			                   Algorithm.ADD_TABLES_ACTION,
			                   Algorithm.UPDATE_LAYOUTS_ACTION,
			                   Algorithm.UPDATE_NETWORK_ACTION,
			                   Algorithm.UPDATE_SELECTION_ACTION,
			                   Algorithm.UPDATE_TABLES_ACTION})
	public List<String> getCyWebActions() {
		return _cyWebActions;
	}

	public void setCyWebActions(List<String> cyWebAction) throws CytoContainerException {
		if (cyWebAction == null){
			_cyWebActions = null;
			return;
		}
		for (String action : cyWebAction){
			if (action != null && !ACTION_SET.contains(action)){
				throw new CytoContainerException(action + " from " + cyWebAction + " is not a valid action");
			}
		}
		this._cyWebActions = cyWebAction;
	}

	@Schema(description="Defines data this algorithm expects to receive")
	public ServiceInputDefinition getServiceInputDefinition() {
		return _serviceInputDefinition;
	}

	public void setServiceInputDefinition(ServiceInputDefinition serviceInputDefinition) {
		this._serviceInputDefinition = serviceInputDefinition;
	}

	
	@Schema(description="Any custom parameters this algorithm accepts")
    public Set<AlgorithmParameter> getParameters() {
        if (_parameters == null){
            return null;
        }
        return new HashSet(_parameters.values());
    }

    public void setParameters(Set<AlgorithmParameter> parameters) {
        if (parameters == null){
            this._parameters = null;
            return;
        }
        if (this._parameters == null){
            this._parameters = new HashMap<>();
        }else {
            this._parameters.clear();
        }
        for (AlgorithmParameter cp : parameters){
            if (cp.getDisplayName()== null){
                continue;
            }
            this._parameters.put(cp.getDisplayName(), cp);
        }
    }
	
	@JsonIgnore
	private void addParameter(AlgorithmParameter param){
		if (param == null){
			return;
		}
		if (param.getDisplayName()== null){
			return;
		}

		if (_parameters == null){
			_parameters = new HashMap<>();
		}
		_parameters.put(param.getDisplayName(), param);
	}
    
    @JsonIgnore
    public Map<String, AlgorithmParameter> getParameterMap(){
        return this._parameters;
    }
    
}
