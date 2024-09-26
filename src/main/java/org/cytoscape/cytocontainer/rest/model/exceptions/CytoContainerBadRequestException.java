package org.cytoscape.cytocontainer.rest.model.exceptions;

import org.cytoscape.cytocontainer.rest.model.ErrorResponse;

/**
 * Exception that is thrown when an invalid request is received by the service
 * @author churas
 */
public class CytoContainerBadRequestException extends CytoContainerException {
    
    private ErrorResponse _er;
    
    public CytoContainerBadRequestException(String message)
    {
        super(message);
    }
    
    public CytoContainerBadRequestException(String message, ErrorResponse er){
        this(message);
        this._er = er;
    }
    
    public ErrorResponse getErrorResponse(){
        return _er;
    }
}
