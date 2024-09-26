package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import java.util.List;

/**
 * Encapsulates an error encountered by the server
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CXMateResult {
    
	public static final String URN = "urn:cytoscape:communitydetection:";
	public static final String LINK = "https://github.com/cytoscape/communitydetection-rest-server";
	
	public static final String UNKNOWN_SOURCE = "unknown";
	
    private JsonNode _data;
	private List<CXMateError> _errors;
    
    public CXMateResult(){
		_data = new TextNode("");
    }
    
	public CXMateResult(final String sourceAlgorithm, final ErrorResponse error){
		_data = new TextNode("");
		CXMateError cError = new CXMateError();
		
		String srcAlgo;
		if (sourceAlgorithm == null){
			srcAlgo = UNKNOWN_SOURCE;
		} else {
			srcAlgo = sourceAlgorithm;
		}
		
		if (error != null){
			if (error.getMessage() != null){
				cError.setMessage(error.getMessage());
			} else {
				cError.setMessage("Unknown");
			}
			if (error.getDescription() != null){
				cError.setMessage(cError.getMessage() + " : " + error.getDescription());
			}
		} else {
			cError.setMessage("Unknown");
		}
		cError.setType(URN + srcAlgo + ":" + Integer.toString(500));
		cError.setStatus(500);
		cError.setLink("https://github.com/cytoscape/communitydetection-rest-server");
		_errors = Arrays.asList(cError);
	}
	
    public CXMateResult(final String message,
			final String sourceAlgorithm, 
			final int statusCode, Exception ex){
        this();
		String srcAlgo;
		if (sourceAlgorithm == null){
			srcAlgo = UNKNOWN_SOURCE;
		} else {
			srcAlgo = sourceAlgorithm;
		}
		
		CXMateError error = new CXMateError();
		
		error.setMessage(message == null ? "Unknown" : message);
		if (ex != null && ex.getMessage() != null){
			error.setMessage(error.getMessage() + " : " + ex.getMessage());
		}
		
		error.setType(URN + srcAlgo + ":" + Integer.toString(statusCode));
		error.setStatus(statusCode);
		error.setLink("https://github.com/cytoscape/communitydetection-rest-server");
		_errors = Arrays.asList(error);
    }

    /**
     * Fallback implementation of JSON version of object
     * {"data":"",
     *  "errors": [
	 *      {
	 *         "type": "urn:cytoscape:ALGORITHM:405",
	 *         "message": "some error",
	 *         "link": "https://github.com/cytoscape/communitydetection-rest-server",
	 *         "status": 405
	 *      }
	 *  ]
	 * }
     * @return 
     */
    public String asJson(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\n  \"data\": ");
		ObjectMapper mapper = new ObjectMapper();
		try {
			sb.append(mapper.writeValueAsString(getData()));
		} catch(JsonProcessingException jpe){
			sb.append("");
		}
        sb.append(",\n");
        
		sb.append("  \"errors\": ");
		if (_errors == null || _errors.isEmpty()){
			sb.append("[]\n");
		}
		else {
			sb.append("[\n");
			for (CXMateError cError : _errors){
				sb.append(cError.asJson());
			}
			sb.append("  ]\n");
		}
		
        sb.append("}\n");
        return sb.toString();
    }

	@Schema(description="JSON in CX network format")
	public JsonNode getData() {
		return _data;
	}

	public void setData(JsonNode _data) {
		this._data = _data;
	}

	@Schema(description="List of errors")
	public List<CXMateError> getErrors() {
		return _errors;
	}

	public void setErrors(List<CXMateError> _errors) {
		this._errors = _errors;
	}
}
