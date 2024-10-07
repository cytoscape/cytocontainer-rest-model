package org.cytoscape.cytocontainer.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.LinkedHashMap;

/**
 *
 * @author churas
 */
@Schema(description="Contains list of Algorithms offered by all services on this server")
public class Algorithms {
	
	private LinkedHashMap<String, Algorithm> _algorithms;

	
	public Algorithms(){
		
	}
	
	public Algorithms(CytoContainerAlgorithms src){
		if (src == null){
			return;
		}
		if (src.getAlgorithms() == null){
			return;
		}
		_algorithms = new LinkedHashMap<>();
		for (String key: src.getAlgorithms().keySet()){
			_algorithms.put(key, new Algorithm(src.getAlgorithms().get(key)));
		}
	}
	@Schema(description=("List of algorithms"))
    public LinkedHashMap<String, Algorithm> getAlgorithms() {
        return _algorithms;
    }

    public void setAlgorithms(LinkedHashMap<String, Algorithm> algorithms) {
        this._algorithms = algorithms;
    }
	
}
