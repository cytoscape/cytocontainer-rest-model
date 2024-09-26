package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    
    private String id;

    @Schema(description="Id of Community Detection Request",
            example="261fb9b7-75af-4f1a-9caa-e57a4b5fc349")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
