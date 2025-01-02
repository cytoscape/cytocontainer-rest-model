package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.cytoscape.cytocontainer.rest.model.exceptions.CytoContainerException;

/**
 * Defines structure of data that should be fed to service.
 * Either inputNetwork OR inputColumns should be defined in this, not both
 * 
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceInputDefinition {
	
	public static final String NODE_TYPE = "node";
	public static final String EDGE_TYPE = "edge";
	public static final String NETWORK_TYPE = "network";
	public static final Set<String> TYPE_SET = Set.of(NODE_TYPE, EDGE_TYPE, NETWORK_TYPE);

	public static final String SELECTED_SCOPE = "selected";
	public static final String ALL_SCOPE = "all";
	public static final String DYNAMIC_SCOPE = "dynamic";
	public static final Set<String> SCOPE_SET = Set.of(SELECTED_SCOPE, ALL_SCOPE, DYNAMIC_SCOPE);
	
	private String _type;
	private String _scope;
	private List<InputColumn> _inputColumns;
	private InputNetwork _inputNetwork;
	
	public ServiceInputDefinition(){
		_scope = SELECTED_SCOPE;
	}
	
	public ServiceInputDefinition(ServiceInputDefinition sData){
		if (sData == null){
			return;
		}
		_type = sData.getType();
		_scope = sData.getScope();
		if (sData.getInputNetwork() != null){
			_inputNetwork = new InputNetwork(sData.getInputNetwork());
		}
		if (sData.getInputColumns() != null){
			_inputColumns = new ArrayList<>();
			for (InputColumn ic : sData.getInputColumns()){
				_inputColumns.add(new InputColumn(ic));
			}
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

	@Schema(description="List of columns that need to be created. For type of '" + ServiceInputDefinition.NODE_TYPE + "' and '" + ServiceInputDefinition.EDGE_TYPE + "' only.")
	public List<InputColumn> getInputColumns() {
		return _inputColumns;
	}

	public void setInputColumns(List<InputColumn> inputColumns) {
		this._inputColumns = inputColumns;
	}

	@Schema(description="Defines structure of data requested by service. For type of '" + ServiceInputDefinition.NETWORK_TYPE + "' only.")
	public InputNetwork getInputNetwork() {
		return _inputNetwork;
	}

	public void setInputNetwork(InputNetwork inputNetwork) {
		this._inputNetwork = inputNetwork;
	}
	
	
	
	
}
