package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author churas
 */
@Schema(description="Menu or submenu item")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CyWebMenuItemPath {
	private String _name;
	private int _gravity;
	
	@Schema(description="Menu name", example="My App")
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@Schema(description="Sets menu gravity, higher values mean lower on menu", example="10")
	public int getGravity() {
		return _gravity;
	}
	public void setGravity(int _gravity) {
		this._gravity = _gravity;
	}
	

}
