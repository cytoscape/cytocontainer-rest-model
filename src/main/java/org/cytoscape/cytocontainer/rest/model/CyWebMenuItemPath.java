package org.cytoscape.cytocontainer.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class CyWebMenuItemPath {
	private String _name;
	private int _gravity;
	
	@Schema(description="Menu name")
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}
	
	@Schema(description="Sets menu gravity, higher values mean lower on menu")
	public int getGravity() {
		return _gravity;
	}
	public void setGravity(int _gravity) {
		this._gravity = _gravity;
	}
	

}
