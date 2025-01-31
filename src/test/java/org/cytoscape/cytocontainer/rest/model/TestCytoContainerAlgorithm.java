package org.cytoscape.cytocontainer.rest.model;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
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
		assertEquals(null, cda.getHiddenParameters());
		assertEquals(null, cda.getParameterFlagMap());
		

        assertEquals(null, cda.getVersion());
        LinkedHashSet<AlgorithmParameter> cParams = new LinkedHashSet<>();
        AlgorithmParameter cp = new AlgorithmParameter();
        cParams.add(cp);
        cda.setParameters(cParams);
        cda.setDescription("desc");
        cda.setName("name");
        cda.setDockerImage("docker");
		cda.setHiddenParameters(Arrays.asList("one", "two"));
        HashMap<String, String> pMap = new HashMap<>();
		pMap.put("a", "b");
		cda.setParameterFlagMap(pMap);
		
        cda.setVersion("version");
        assertEquals("desc", cda.getDescription());
        assertEquals("name", cda.getName());
        
        assertEquals("docker", cda.getDockerImage());

        assertEquals("version", cda.getVersion());
		assertEquals(cda.getHiddenParameters().size(), 2);
		assertTrue(cda.getHiddenParameters().contains("one"));
		assertTrue(cda.getHiddenParameters().contains("two"));
		assertEquals(cda.getParameterFlagMap().size(), 1);
		assertEquals(cda.getParameterFlagMap().get("a"), "b");
	}	
}
