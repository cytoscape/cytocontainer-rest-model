package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Set;
import org.cytoscape.cytocontainer.rest.model.exceptions.CytoContainerException;

/**
 * Defines expected input for this service to be a network
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputNetwork {
	public static final String NETWORK_MODEL = "network";
	public static final String GRAPH_MODEL = "graph";
	
	public static final Set<String> MODEL_SET = Set.of(NETWORK_MODEL, GRAPH_MODEL);
	
	public static final String CX_FORMAT = "cx2";
	public static final String EDGELIST_FORMAT = "edgelist";
	public static final Set<String> FORMAT_SET = Set.of(CX_FORMAT, EDGELIST_FORMAT);
	
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

	public void setModel(String model) throws CytoContainerException {
		if (model != null && !MODEL_SET.contains(model)){
			throw new CytoContainerException(model + " is not a valid model");
		}
		this._model = model;
	}

	@Schema(description="Denotes format of returned data. '" + InputNetwork.CX_FORMAT + "' returns CX2 format.",
			allowableValues = {InputNetwork.CX_FORMAT,
			                   InputNetwork.EDGELIST_FORMAT}, example=InputNetwork.CX_FORMAT)
	public String getFormat() {
		return _format;
	}

	public void setFormat(String format) throws CytoContainerException {
		if (format != null && !FORMAT_SET.contains(format)){
			throw new CytoContainerException(format + " is not a valid format");
		}
		this._format = format;
	}
	
	
}
