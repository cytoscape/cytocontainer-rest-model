package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CytoContainerAlgorithms {
    
    private LinkedHashMap<String, CytoContainerAlgorithm> algorithms;
	
    public LinkedHashMap<String, CytoContainerAlgorithm> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(LinkedHashMap<String, CytoContainerAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }
	
}
