package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.cytoscape.cytocontainer.rest.model.exceptions.CytoContainerException;

/**
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
	private String _cyWebAction;
	private SelectedData _selectedData;
	private CyWebMenuItem _cyWebMenuItem;

	private HashMap<String, AlgorithmParameter> _parameters;
	
	public Algorithm(){
		
	}
	
	public Algorithm(CytoContainerAlgorithm algorithm){
		if (algorithm == null){
			return;
		}
		_name = algorithm.getName();
		_description = algorithm.getDescription();
		_version = algorithm.getVersion();
		_cyWebAction = algorithm.getCyWebAction();
		if (algorithm.getParameterMap() != null){
			for (String key : algorithm.getParameterMap().keySet()){
				addParameter(algorithm.getParameterMap().get(key));
			}
		}
		if (algorithm.getSelectedData() != null){
			_selectedData = new SelectedData(algorithm.getSelectedData());
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

	@Schema(description="Optional action to be performed with result. Can be one of the following: (AddNetworks, UpdateNetwork, AddTables, UpdateTables, UpdateLayouts) See: "
            + " https://github.com/cytoscape-web\n")
	public String getCyWebAction() {
		return _cyWebAction;
	}

	public void setCyWebAction(String cyWebAction) throws CytoContainerException {
		if (cyWebAction != null && !ACTION_SET.contains(cyWebAction)){
			throw new CytoContainerException(cyWebAction + " is not a valid action");
		}
		this._cyWebAction = cyWebAction;
	}

	@Schema(description="Defines data this algorithm expects to receive")
	public SelectedData getSelectedData() {
		return _selectedData;
	}

	public void setSelectedData(SelectedData _selectedData) {
		this._selectedData = _selectedData;
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
            if (cp.getFlag()== null){
                continue;
            }
            this._parameters.put(cp.getFlag(), cp);
        }
    }
	
	private void addParameter(AlgorithmParameter param){
		if (param == null){
			return;
		}
		if (param.getFlag() == null){
			return;
		}

		if (_parameters == null){
			_parameters = new HashMap<>();
		}
		_parameters.put(param.getFlag(), param);
	}
    
    @JsonIgnore
    public Map<String, AlgorithmParameter> getParameterMap(){
        return this._parameters;
    }

    
}
