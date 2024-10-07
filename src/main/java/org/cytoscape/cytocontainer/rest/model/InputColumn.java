package org.cytoscape.cytocontainer.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Defines expected input data to service to be either
 * nodes or edges columns
 * 
 * @author churas
 */
public class InputColumn {
	private String _name;
	private String _description;
	private String _dataType;
	private String _defaultColumnName;
	private String _columnName;
	
	public InputColumn(){
	}
	
	public InputColumn(InputColumn src){
		if (src == null){
			return;
		}
		_name = src.getName();
		_description = src.getDescription();
		_dataType = src.getDataType();
		_defaultColumnName = src.getDefaultColumnName();
		_columnName = src.getColumnName();
	}

	@Schema(description="The label text of the dropdown list. It will also be used as the column name in the generated data block.")
	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	@Schema(description="A short description of the column. Used as a hint in the UI.")
	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	@Schema(description="Data type of the attribute. When defined, Cytoscape Web uses it to filter the dropdown list. If omitted, the dropdown will contain all columns.")
	public String getDataType() {
		return _dataType;
	}

	public void setDataType(String dataType) {
		this._dataType = dataType;
	}

	@Schema(description="(Optional) The default selection in the column name dropdown. If the column specified in field doesn't exist in node or edge table, no selection will be make.")
	public String getDefaultColumnName() {
		return _defaultColumnName;
	}

	public void setDefaultColumnName(String defaultColumnName) {
		this._defaultColumnName = defaultColumnName;
	}

	@Schema(description="Name of the column that should be automatically included. No UI control will be generated for this column. Treated like a preselected value for name attribute.")
	public String getColumnName() {
		return _columnName;
	}

	public void setColumnName(String columnName) {
		this._columnName = columnName;
	}
	
	
}
