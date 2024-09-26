package org.cytoscape.cytocontainer.rest.model;

import org.cytoscape.cytocontainer.rest.model.CytoContainerResult;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author churas
 */
public class TestCytoContainerResult {
    
    @Test
    public void testConstructorWithStartTime(){
        CytoContainerResult eqr = new CytoContainerResult(1);
        assertEquals(1, eqr.getStartTime());
    }
    
    @Test
    public void testUpdateStartTime(){
        CytoContainerResult eqr = new CytoContainerResult(1);
        assertEquals(1, eqr.getStartTime());
        CytoContainerResult updated = new CytoContainerResult();
        assertEquals(0, updated.getStartTime());
        
        updated.updateStartTime(eqr);
        assertEquals(1, updated.getStartTime());
        
        // try null copy which doesnt change anything
        updated.updateStartTime(null);
        assertEquals(1, updated.getStartTime());
        
    }
    
    @Test
    public void testGettersAndSetters(){
        CytoContainerResult eqr = new CytoContainerResult();
        assertEquals(null, eqr.getId());
        assertEquals(null, eqr.getMessage());
        assertEquals(0, eqr.getProgress());
        assertEquals(0, eqr.getStartTime());
        assertEquals(null, eqr.getStatus());
        assertEquals(0, eqr.getWallTime());
        assertEquals(null, eqr.getResult());
        
        eqr.setId("id");
        eqr.setMessage("message");
        eqr.setProgress(2);
        
        eqr.setStartTime(5);
        eqr.setStatus("status");
        eqr.setWallTime(6);
        TextNode tnode = new TextNode("hi");
        eqr.setResult(tnode);
        
        assertEquals("id", eqr.getId());
        assertEquals("message", eqr.getMessage());
        assertEquals(2, eqr.getProgress());
        assertEquals(5, eqr.getStartTime());
        assertEquals("status", eqr.getStatus());
        assertEquals(6, eqr.getWallTime());
        assertEquals(tnode, eqr.getResult());
    }
}
