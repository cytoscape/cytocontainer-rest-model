package org.cytoscape.cytocontainer.rest.model;


import org.cytoscape.cytocontainer.rest.model.AlgorithmParameter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author churas
 */
public class TestCytoContainerParameter {
    
    @Test
    public void testGettersAndSetters(){
        AlgorithmParameter cp = new AlgorithmParameter();
        assertEquals(null, cp.getDefaultValue());
        assertEquals(null, cp.getDescription());
        assertEquals(null, cp.getDisplayName());
        assertEquals(null, cp.getMaxValue());
        assertEquals(null, cp.getMinValue());
        assertEquals(null, cp.getFlag());
        assertEquals(null, cp.getType());
        assertEquals(null, cp.getValidationHelp());
        assertEquals(null, cp.getValidationRegex());
        assertEquals(null, cp.getValidationType());
        
        cp.setDefaultValue("default");
        cp.setDescription("description");
        cp.setDisplayName("displayname");
        cp.setMaxValue(10);
        cp.setMinValue(2);
        cp.setFlag("name");
        cp.setType("type");
        cp.setValidationHelp("help");
        cp.setValidationRegex("regex");
        cp.setValidationType("validtype");
        
        assertEquals("default", cp.getDefaultValue());
        assertEquals("description", cp.getDescription());
        assertEquals("displayname", cp.getDisplayName());
        assertEquals(10, cp.getMaxValue());
        assertEquals(2, cp.getMinValue());
        assertEquals("name", cp.getFlag());
        assertEquals("type", cp.getType());
        assertEquals("help", cp.getValidationHelp());
        assertEquals("regex", cp.getValidationRegex());
        assertEquals("validtype", cp.getValidationType());
        
    }
    
}
