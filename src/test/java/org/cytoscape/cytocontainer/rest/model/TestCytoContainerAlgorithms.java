package org.cytoscape.cytocontainer.rest.model;


import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author churas
 */
public class TestCytoContainerAlgorithms {
    
    @Test
    public void testGettersAndSetters(){
        CytoContainerAlgorithms cda = new CytoContainerAlgorithms();

		assertNull(cda.getAlgorithms());
		
		LinkedHashMap<String, CytoContainerAlgorithm> algoMap = new LinkedHashMap<>();
		CytoContainerAlgorithm cca = new CytoContainerAlgorithm();
		cca.setName("my algo");
		algoMap.put("foo", cca);
		cda.setAlgorithms(algoMap);
		
		assertEquals(cda.getAlgorithms().size(), 1);
		
		assertEquals(cda.getAlgorithms().get("foo").getName(), "my algo");
		
		
	}	
}
