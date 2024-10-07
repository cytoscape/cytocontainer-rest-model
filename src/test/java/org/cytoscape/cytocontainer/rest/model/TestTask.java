package org.cytoscape.cytocontainer.rest.model;


import org.cytoscape.cytocontainer.rest.model.CytoContainerRequestId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author churas
 */
public class TestTask {
    
    @Test
    public void testGettersAndSetters(){
        CytoContainerRequestId t = new CytoContainerRequestId();
        assertEquals(null, t.getId());
        t.setId("hi");
        assertEquals("hi", t.getId());        
    }
    
}
