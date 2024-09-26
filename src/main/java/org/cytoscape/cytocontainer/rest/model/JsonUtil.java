package org.cytoscape.cytocontainer.rest.model;

/**
 * Helper class to to build a JSON String
 * @author churas
 */
public class JsonUtil {
	
	/**
	 * Wraps input <b>value</b> in double quotes and replaces newlines, 
	 * carriage returns, and tabs with a space. Method also escapes all double quotes.
	 * 
	 * @param value input String
	 * @return {@code "null"} if <b>value</b> is {@code null} otherwise wraps string
	 *         as described above
	 */
	public static String getValueAsJsonString(final String value){
        if (value == null){
            return "null";
        }
        return "\"" + value.replaceAll("\"", "\\\\\"").replaceAll("\n|\t|\r", " ") + "\"";
    }
}
