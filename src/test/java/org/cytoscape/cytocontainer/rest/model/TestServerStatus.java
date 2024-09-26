package org.cytoscape.cytocontainer.rest.model;

import org.cytoscape.cytocontainer.rest.model.ServerStatus;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author churas
 */
public class TestServerStatus {
    
    public TestServerStatus() {
    }
    

    @Test
    public void testGettersAndSetters(){
        ServerStatus ss = new ServerStatus();
        assertEquals(null, ss.getLoad());
        assertEquals(0, ss.getPcDiskFull());
        assertEquals(0, ss.getCompletedTasks());
        assertEquals(0, ss.getQueuedTasks());
        assertEquals(null, ss.getVersion());
        assertEquals(null, ss.getStatus());
        assertEquals(0, ss.getCanceledTasks());
        
        ArrayList<Float> load = new ArrayList<>();
        load.add(Float.NaN);
        ss.setLoad(load);
        ss.setPcDiskFull(10);
        ss.setQueuedTasks(1);
        ss.setCompletedTasks(2);
        ss.setCanceledTasks(3);
        
        ss.setVersion("version");
        ss.setStatus("status");
        
        assertEquals((float)Float.NaN, (float)ss.getLoad().get(0));
        assertEquals(10, ss.getPcDiskFull());
        assertEquals(1, ss.getQueuedTasks());
        assertEquals(2, ss.getCompletedTasks());
        assertEquals(3, ss.getCanceledTasks());
        assertEquals("version", ss.getVersion());
        assertEquals("status", ss.getStatus());
        
        
        
    }
}
