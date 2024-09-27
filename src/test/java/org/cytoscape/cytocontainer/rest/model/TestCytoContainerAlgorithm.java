package org.cytoscape.cytocontainer.rest.model;


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
        assertEquals(null, cda.getParameters());
        assertEquals(null, cda.getDescription());
        assertEquals(null, cda.getName());
        assertEquals(null, cda.getDockerImage());

        assertEquals(null, cda.getVersion());
        HashSet<Parameter> cParams = new HashSet<>();
        Parameter cp = new Parameter();
        cp.setName("x");
        cParams.add(cp);
        cda.setParameters(cParams);
        cda.setDescription("desc");
        cda.setName("name");
        cda.setDockerImage("docker");
        
        cda.setVersion("version");
        assertEquals("x", cda.getParameters().iterator().next().getName());
        assertEquals("desc", cda.getDescription());
        assertEquals("name", cda.getName());
        
        assertEquals("docker", cda.getDockerImage());

        assertEquals("version", cda.getVersion());
        
    }
}
