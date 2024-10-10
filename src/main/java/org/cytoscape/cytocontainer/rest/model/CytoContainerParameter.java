package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerParameter extends AlgorithmParameter {
	
	private String _flag;

	public String getFlag() {
		return _flag;
	}

	public void setFlag(String _flag) {
		this._flag = _flag;
	}
	
	
}
