package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Encapsulates an error encountered by the server
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CXMateError {
    
    private String _type;
	private String _message;
	private String _link;
	private int _status;
	
    
    public CXMateError(){
    }

	
    /**
     * Fallback implementation of json version of object
     * {"message":"hi",
     *  "stackTrace":"org.ndexbio.enri",
     *  "threadId":"1",
     *  "description":"well",
     *  "errorCode":null,
     *  "timeStamp":null}
     * @return 
     */
    public String asJson(){
        StringBuilder sb = new StringBuilder();
		sb.append("    {\n      \"type\": ");
		sb.append(JsonUtil.getValueAsJsonString(_type));
		sb.append("    ,\n");
		
		sb.append("      \"message\": ");
		sb.append(JsonUtil.getValueAsJsonString(_message));
		sb.append("    ,\n");
		
		sb.append("      \"link\": ");
		sb.append(JsonUtil.getValueAsJsonString(_link));
		sb.append("    ,\n");
		
		sb.append("      \"status\": ");
		sb.append(Integer.toString(_status));
		sb.append("\n    }\n");
		
		
        return sb.toString();
    }

	@Schema(description="Uniform Resource Name")
	public String getType() {
		return _type;
	}

	public void setType(String _type) {
		this._type = _type;
	}

	@Schema(description="Description of error")
	public String getMessage() {
		return _message;
	}

	public void setMessage(String _message) {
		this._message = _message;
	}

	@Schema(description="Link to app source")
	public String getLink() {
		return _link;
	}

	public void setLink(String _link) {
		this._link = _link;
	}

	@Schema(description="Error code to identify issue. Usually a HTTP status code")
	public int getStatus() {
		return _status;
	}

	public void setStatus(int _status) {
		this._status = _status;
	}

	
   
    
}
