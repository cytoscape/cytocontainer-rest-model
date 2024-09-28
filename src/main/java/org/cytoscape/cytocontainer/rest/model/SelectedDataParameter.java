package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;



/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectedDataParameter {
	
	public static final String CX_FORMAT = "cx2";
	public static final String EDGELIST_FORMAT = "edgelist";
	
	public static final String NETWORK_MODEL = "network";
	public static final String GRAPH_MODEL = "graph";
	
	private String _name;
	private String _description;
	private String _dataType;
	private String _model;
	private String _format;
	
	public SelectedDataParameter(){
		
	}
	
	public SelectedDataParameter(SelectedDataParameter src){
		if (src == null){
			return;
		}
		_name = src.getName();
		_description = src.getDescription();
		_dataType = src.getDataType();
		_model = src.getModel();
		_format = src.getFormat();
	}
	
	public SelectedDataParameter copy(){
		return new SelectedDataParameter(this);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	public String getDataType() {
		return _dataType;
	}

	public void setDataType(String dataType) {
		this._dataType = dataType;
	}

	public String getModel() {
		return _model;
	}

	public void setModel(String model) {
		this._model = model;
	}

	public String getFormat() {
		return _format;
	}

	public void setFormat(String format) {
		this._format = format;
	}
	
}
