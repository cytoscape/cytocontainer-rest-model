package org.cytoscape.cytocontainer.rest.model;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author churas
 */
public class TestSelectedData {
	
	@Test
	public void testGettersAndSetters(){
		SelectedData sda = new SelectedData();
		assertEquals(SelectedData.SELECTED_SCOPE, sda.getScope());
		assertEquals(null, sda.getType());
		assertEquals(null, sda.getParameters());
		
		SelectedDataParameter nsdp = new SelectedDataParameter();
		nsdp.setFormat(SelectedDataParameter.CX_FORMAT);
		nsdp.setModel(SelectedDataParameter.GRAPH_MODEL);
		sda.setParameters(Arrays.asList(nsdp));
		assertEquals(1, sda.getParameters().size());
		SelectedDataParameter result = sda.getParameters().get(0);
		assertEquals(SelectedDataParameter.CX_FORMAT, result.getFormat());
		assertEquals(SelectedDataParameter.GRAPH_MODEL, result.getModel());
	}
	
	
}
