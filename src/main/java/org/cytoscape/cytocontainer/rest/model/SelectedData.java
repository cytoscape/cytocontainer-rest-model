package org.cytoscape.cytocontainer.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.cytoscape.cytocontainer.rest.model.exceptions.CytoContainerException;

/**
 * Defines structure of data that should be fed to ServiceAlgorithm
 * @author churas
 */
public class SelectedData {
	
	public static final String NODES_TYPE = "nodes";
	public static final String EDGES_TYPE = "edges";
	public static final String NETWORK_TYPE = "network";
	public static final Set<String> TYPE_SET = Set.of(NODES_TYPE, EDGES_TYPE, NETWORK_TYPE);

	public static final String SELECTED_SCOPE = "selected";
	public static final String ALL_SCOPE = "all";
	public static final Set<String> SCOPE_SET = Set.of(SELECTED_SCOPE, ALL_SCOPE);
	
	private String _type;
	private String _scope;
	private List<SelectedDataParameter> _parameters;
	
	public SelectedData(){
		_scope = SELECTED_SCOPE;
	}
	
	public SelectedData(SelectedData sData){
		if (sData == null){
			return;
		}
		_type = sData.getType();
		_scope = sData.getScope();
		if (sData.getParameters() == null){
			return;
		}
		_parameters = new ArrayList<>();
		for(SelectedDataParameter sdp : sData.getParameters()){
			_parameters.add(sdp.copy());
		}
	
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) throws CytoContainerException {
		if (type != null && !TYPE_SET.contains(type)){
			throw new CytoContainerException(type + " is not a valid type");
		}
		this._type = type;
	}

	public String getScope() {
		return _scope;
	}

	public void setScope(String scope) throws CytoContainerException {
		if (scope != null && !SCOPE_SET.contains(scope)){
			throw new CytoContainerException(scope + " is not a valid scope");
		}
		this._scope = scope;
	}

	public List<SelectedDataParameter> getParameters() {
		return _parameters;
	}

	public void setParameters(List<SelectedDataParameter> parameters) {
		_parameters = parameters;
	}
}
