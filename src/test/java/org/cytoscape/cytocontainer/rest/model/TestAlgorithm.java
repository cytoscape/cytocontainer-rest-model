package org.cytoscape.cytocontainer.rest.model;


import java.util.Arrays;
import java.util.LinkedHashSet;
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
		assertEquals(false, cda.getShowDescriptionInDialog());
		assertEquals(null, cda.getEmail());
		assertEquals(null, cda.getCodeRepository());
		assertEquals(null, cda.getWebsite());
		assertEquals(null, cda.getTutorial());
		assertEquals(null, cda.getParameters());
		
		

        assertEquals(null, cda.getVersion());
        LinkedHashSet<AlgorithmParameter> cParams = new LinkedHashSet<>();
        AlgorithmParameter cp = new AlgorithmParameter();
        cParams.add(cp);
        cda.setParameters(cParams);
        cda.setDescription("desc");
        cda.setName("name");
		cda.setVersion("version");
		cda.setCitation("citation");
		cda.setAuthor("author");
		cda.setCyWebActions(Arrays.asList(Algorithm.ADD_NETWORKS_ACTION));
		cda.setShowDescriptionInDialog(true);
		cda.setEmail("email");
		cda.setCodeRepository("https://coderepo");
		cda.setWebsite("https://website");
		cda.setTutorial("https://tutorial");
		
       
		
        cda.setVersion("version");
        assertEquals("desc", cda.getDescription());
        assertEquals("name", cda.getName());
		assertEquals(true, cda.getShowDescriptionInDialog());
		assertEquals("email", cda.getEmail());
		assertEquals("https://coderepo", cda.getCodeRepository());
		assertEquals("https://website", cda.getWebsite());
		assertEquals("https://tutorial", cda.getTutorial());

        assertEquals("version", cda.getVersion());
	}	
}
