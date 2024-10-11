package org.cytoscape.cytocontainer.rest.model;

import java.util.Arrays;
import java.util.Set;

/**
 * Contains list of CX data types
 * @author churas
 */
public class CXDataType {
	
	public static final String STRING_TYPE = "string";
	public static final String LONG_TYPE = "long";
	public static final String INTEGER_TYPE = "integer";
	public static final String DOUBLE_TYPE = "double";
	public static final String BOOLEAN_TYPE = "boolean";
	
	public static final String LIST_OF_STRING_TYPE = "list_of_string";
	public static final String LIST_OF_LONG_TYPE = "list_of_long";
	public static final String LIST_OF_INTEGER_TYPE = "list_of_integer";
	public static final String LIST_OF_DOUBLE_TYPE = "list_of_double";
	public static final String LIST_OF_BOOLEAN_TYPE = "list_of_boolean";
	
	public static final String LIST_OF = "list";
	public static final String WHOLE_NUMBER = "wholenumber";
	public static final String NUMBER = "number";
	public static final String LIST_OF_WHOLE_NUMBER = "list_of_wholenumber";
	public static final String LIST_OF_NUMBER = "list_of_number";

	public static final Set<String> DATATYPE_SET = Set.of(STRING_TYPE, LONG_TYPE, INTEGER_TYPE, DOUBLE_TYPE, BOOLEAN_TYPE,
			LIST_OF_STRING_TYPE, LIST_OF_LONG_TYPE, LIST_OF_INTEGER_TYPE, LIST_OF_DOUBLE_TYPE, LIST_OF_BOOLEAN_TYPE);
	
	public static final Set<String> COLUMN_FILTER_SET = Set.of(STRING_TYPE, LONG_TYPE, INTEGER_TYPE, DOUBLE_TYPE, BOOLEAN_TYPE,
			LIST_OF_STRING_TYPE, LIST_OF_LONG_TYPE, LIST_OF_INTEGER_TYPE, LIST_OF_DOUBLE_TYPE, LIST_OF_BOOLEAN_TYPE,
			LIST_OF, WHOLE_NUMBER, NUMBER, LIST_OF_WHOLE_NUMBER, LIST_OF_NUMBER);
	
}
