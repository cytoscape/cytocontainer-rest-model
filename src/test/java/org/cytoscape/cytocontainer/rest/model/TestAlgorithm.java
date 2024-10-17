package org.cytoscape.cytocontainer.rest.model;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author churas
 */
public class TestAlgorithm {
    
    @Test
    public void testGettersAndSetters() throws Exception {
        Algorithm cda = new Algorithm();
        assertEquals(null, cda.getParameters());
        assertEquals(null, cda.getDescription());
        assertEquals(null, cda.getName());
        assertEquals(null, cda.getVersion());
		assertEquals(null, cda.getCyWebActions());
		assertEquals(null, cda.getAuthor());
		assertEquals(null, cda.getCitation());
		assertEquals(null, cda.getServiceInputDefinition());
		assertEquals(null, cda.getCyWebMenuItem());
		
		

        assertEquals(null, cda.getVersion());
        HashSet<AlgorithmParameter> cParams = new HashSet<>();
        AlgorithmParameter cp = new AlgorithmParameter();
        cParams.add(cp);
        cda.setParameters(cParams);
        cda.setDescription("desc");
        cda.setName("name");
		cda.setVersion("version");
		cda.setCitation("citation");
		cda.setAuthor("author");
		cda.setCyWebActions(Arrays.asList(Algorithm.ADD_NETWORKS_ACTION));
		
       
		
        cda.setVersion("version");
        assertEquals("desc", cda.getDescription());
        assertEquals("name", cda.getName());

        assertEquals("version", cda.getVersion());
	}	
}
