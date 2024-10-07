package org.cytoscape.cytocontainer.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Defines expected input for this service to be a network
 * @author churas
 */
public class InputNetwork {
	public static final String NETWORK_MODEL = "network";
	public static final String GRAPH_MODEL = "graph";
	
	public static final String CX_FORMAT = "cx2";
	private String _model;
	private String _format;

	public InputNetwork(){
		
	}
	
	public InputNetwork(InputNetwork src){
		if (src == null){
			return;
		}
		_model = src.getModel();
		_format = src.getFormat();
	}
	
	@Schema(description="Denotes network content returned. '" + InputNetwork.NETWORK_MODEL + "' denotes full network data and '" + InputNetwork.GRAPH_MODEL + "' denotes bare network (ids only)",
			allowableValues={InputNetwork.NETWORK_MODEL,
			                 InputNetwork.GRAPH_MODEL}, example=InputNetwork.NETWORK_MODEL)
	public String getModel() {
		return _model;
	}

	public void setModel(String model) {
		this._model = model;
	}

	@Schema(description="Denotes format of returned data. '" + InputNetwork.CX_FORMAT + "' returns CX2 format.",
			allowableValues = {InputNetwork.CX_FORMAT}, example=InputNetwork.CX_FORMAT)
	public String getFormat() {
		return _format;
	}

	public void setFormat(String format) {
		this._format = format;
	}
	
	
}
