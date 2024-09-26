package org.cytoscape.cytocontainer.rest.model;

import org.cytoscape.cytocontainer.rest.model.CytoContainerRequest;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author churas
 */
public class TestCytoContainerRequest {
    
    @Test
    public void testGettersAndSetters(){
        CytoContainerRequest eq = new CytoContainerRequest();
        eq.setAlgorithm("algo");
        eq.setData(new TextNode("hi"));
        HashMap<String, String> cParams = new HashMap<>();
        cParams.put("hi", "bye");
        eq.setCustomParameters(cParams);
        assertEquals("algo", eq.getAlgorithm());
        assertEquals("hi", eq.getData().asText());
        assertEquals("bye", eq.getCustomParameters().get("hi"));
    }
}
