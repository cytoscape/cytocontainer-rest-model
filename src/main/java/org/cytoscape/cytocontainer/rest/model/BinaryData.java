package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Set in Result under CommunityDetectionResult when output from 
 * algorithm is binary data
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BinaryData {
	private String _ContentType;
	private long _sizeInBytes;
	private String _downloadUrl;

	public String getContentType() {
		return _ContentType;
	}

	public void setContentType(String _ContentType) {
		this._ContentType = _ContentType;
	}

	public long getSizeInBytes() {
		return _sizeInBytes;
	}

	public void setSizeInBytes(long sizeInBytes) {
		this._sizeInBytes = sizeInBytes;
	}

	public String getDownloadUrl() {
		return _downloadUrl;
	}

	public void setDownloadUrl(String _downloadUrl) {
		this._downloadUrl = _downloadUrl;
	}
}
