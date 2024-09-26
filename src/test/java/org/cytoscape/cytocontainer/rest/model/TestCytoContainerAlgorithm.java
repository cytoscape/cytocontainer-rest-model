package org.cytoscape.cytocontainer.rest.model;

import org.cytoscape.cytocontainer.rest.model.CytoContainerAlgorithm;
import org.cytoscape.cytocontainer.rest.model.Parameter;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author churas
 */
public class TestCytoContainerAlgorithm {
    
    @Test
    public void testGettersAndSetters(){
        CytoContainerAlgorithm cda = new CytoContainerAlgorithm();
        assertEquals(null, cda.getCustomParameters());
        assertEquals(null, cda.getDescription());
        assertEquals(null, cda.getName());
        assertEquals(null, cda.getDockerImage());
        assertEquals(null, cda.getInputDataFormat());
        assertEquals(null, cda.getOutputDataFormat());
        assertEquals(null, cda.getVersion());
        HashSet<Parameter> cParams = new HashSet<>();
        Parameter cp = new Parameter();
        cp.setName("x");
        cParams.add(cp);
        cda.setCustomParameters(cParams);
        cda.setDescription("desc");
        cda.setName("name");
        cda.setDockerImage("docker");
        cda.setInputDataFormat("input");
        cda.setOutputDataFormat("output");
        cda.setVersion("version");
        assertEquals("x", cda.getCustomParameters().iterator().next().getName());
        assertEquals("desc", cda.getDescription());
        assertEquals("name", cda.getName());
        
        assertEquals("docker", cda.getDockerImage());
        assertEquals("input", cda.getInputDataFormat());
        assertEquals("output", cda.getOutputDataFormat());
        assertEquals("version", cda.getVersion());
        
    }
}
