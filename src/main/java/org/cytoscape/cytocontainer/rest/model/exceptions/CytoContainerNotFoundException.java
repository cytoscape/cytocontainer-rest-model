package org.cytoscape.cytocontainer.rest.model.exceptions;

import org.cytoscape.cytocontainer.rest.model.ErrorResponse;

/**
 * Exception that is thrown when request for entity is not found
 * @author churas
 */
public class CytoContainerNotFoundException extends CytoContainerException {
    
    private ErrorResponse _er;
    
    public CytoContainerNotFoundException(String message)
    {
        super(message);
    }
    
    public CytoContainerNotFoundException(String message, ErrorResponse er){
        this(message);
        this._er = er;
    }
    
    public ErrorResponse getErrorResponse(){
        return _er;
    }
}
