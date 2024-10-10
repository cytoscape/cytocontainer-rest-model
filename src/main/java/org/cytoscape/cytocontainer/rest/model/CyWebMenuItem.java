package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

/**
 * Defines menu for service
 * 
 * @author churas
 */
@Schema(description="Defines menu for service")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CyWebMenuItem {
	private String _root;
	private List<CyWebMenuItemPath> _path;
	
	@Schema(description="Top level menu to place this service", example="Apps")
	public String getRoot() {
		return _root;
	}
	public void setRoot(String _root) {
		this._root = _root;
	}
	
	@Schema(description="Service menu path and name")
	public List<CyWebMenuItemPath> getPath() {
		return _path;
	}
	public void setPath(List<CyWebMenuItemPath> _path) {
		this._path = _path;
	}
	
	

}
