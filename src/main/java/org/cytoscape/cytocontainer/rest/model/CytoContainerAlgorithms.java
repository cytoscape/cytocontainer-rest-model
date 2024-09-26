package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.LinkedHashMap;

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
