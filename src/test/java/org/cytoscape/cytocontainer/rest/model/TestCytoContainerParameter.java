package org.cytoscape.cytocontainer.rest.model;


import org.cytoscape.cytocontainer.rest.model.exceptions.CytoContainerException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author churas
 */
public class TestCytoContainerParameter {
    
    @Test
    public void testGettersAndSetters() throws CytoContainerException {
        CytoContainerParameter cp = new CytoContainerParameter();
        assertEquals(null, cp.getDefaultValue());
        assertEquals(null, cp.getDescription());
        assertEquals(null, cp.getDisplayName());
        assertEquals(null, cp.getMaxValue());
        assertEquals(null, cp.getMinValue());
        assertEquals(null, cp.getType());
        assertEquals(null, cp.getValidationHelp());
        assertEquals(null, cp.getValidationRegex());
        assertEquals(null, cp.getValidationType());
        
        cp.setDefaultValue("default");
        cp.setDescription("description");
        cp.setDisplayName("displayname");
        cp.setMaxValue(10);
        cp.setMinValue(2);
        cp.setType(CytoContainerParameter.TEXT_TYPE);
        cp.setValidationHelp("help");
        cp.setValidationRegex("regex");
        cp.setValidationType(CytoContainerParameter.DIGITS_VALIDATION);
        
        assertEquals("default", cp.getDefaultValue());
        assertEquals("description", cp.getDescription());
        assertEquals("displayname", cp.getDisplayName());
        assertEquals(10, cp.getMaxValue());
        assertEquals(2, cp.getMinValue());
        assertEquals(CytoContainerParameter.TEXT_TYPE, cp.getType());
        assertEquals("help", cp.getValidationHelp());
        assertEquals("regex", cp.getValidationRegex());
        assertEquals(CytoContainerParameter.DIGITS_VALIDATION, cp.getValidationType());
        
    }
    
}
