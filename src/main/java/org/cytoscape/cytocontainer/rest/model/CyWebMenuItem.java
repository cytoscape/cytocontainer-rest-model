package org.cytoscape.cytocontainer.rest.model;

import java.util.List;

public class CyWebMenuItem {
	private String _root;
	private List<CyWebMenuItemPath> _path;
	
	public String getRoot() {
		return _root;
	}
	public void setRoot(String _root) {
		this._root = _root;
	}
	public List<CyWebMenuItemPath> getPath() {
		return _path;
	}
	public void setPath(List<CyWebMenuItemPath> _path) {
		this._path = _path;
	}
	
	

}
