package org.cytoscape.cytocontainer.rest.model;

import org.cytoscape.cytocontainer.rest.model.CytoContainerResult;
import org.cytoscape.cytocontainer.rest.model.CytoContainerResultStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author churas
 */
public class TestCytoContainerResultStatus {
    
    @Test
    public void testConstructorThatTakesCommunityDetectionResult(){
        
        CytoContainerResultStatus cStatus = new CytoContainerResultStatus(null);
        assertEquals(0, cStatus.getStartTime());
        assertEquals(0, cStatus.getWallTime());
        assertEquals(0, cStatus.getProgress());
        assertEquals(null, cStatus.getMessage());
        assertEquals(null, cStatus.getId());
        
        CytoContainerResult cdr = new CytoContainerResult();
        cdr.setId("id");
        cdr.setMessage("message");
        cdr.setProgress(25);
        cdr.setWallTime(10);
        cdr.setStartTime(5);
        
        cStatus = new CytoContainerResultStatus(cdr);
        assertEquals(5, cStatus.getStartTime());
        assertEquals(10, cStatus.getWallTime());
        assertEquals(25, cStatus.getProgress());
        assertEquals("message", cStatus.getMessage());
        assertEquals("id", cStatus.getId());
        
        
    }
}
