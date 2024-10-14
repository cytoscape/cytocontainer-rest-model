package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.cytoscape.cytocontainer.rest.model.exceptions.CytoContainerException;

/**
 *
 * @author churas
 */
@Schema(description="Parameter that can be passed to Algorithm")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlgorithmParameter {
    
	public static final String TEXT_TYPE = "text";
	public static final String DROPDOWN_TYPE = "dropDown";
	public static final String RADIO_TYPE = "radio";
	public static final String CHECKBOX_TYPE = "checkBox";
	public static final String NODECOLUMN_TYPE = "nodeColumn";
	public static final String EDGECOLUMN_TYPE = "edgeColumn";
    public static final String FLAG_TYPE = "flag";
	
	public static final Set<String> TYPE_SET = Set.of(TEXT_TYPE, DROPDOWN_TYPE, RADIO_TYPE, CHECKBOX_TYPE,
			NODECOLUMN_TYPE, EDGECOLUMN_TYPE);
    
    public static final String NUMBER_VALIDATION = "number";
    public static final String DIGITS_VALIDATION = "digits";
    public static final String STRING_VALIDATION = "string";
	
	public static final Set<String> VALIDATION_SET = Set.of(NUMBER_VALIDATION, DIGITS_VALIDATION, STRING_VALIDATION);
    
    private String displayName;
    private String description;
    private String type;
	private List<String> valueList;
    private String defaultValue;
    private String validationType;
    private String validationHelp;
    private String validationRegex;
	private String columnTypeFilter;
    private Number minValue;
    private Number maxValue;
   
	public AlgorithmParameter(){
		
	}
	public AlgorithmParameter(AlgorithmParameter src){
		if (src == null){
			return;
		}
		displayName = src.getDisplayName();
		description = src.getDescription();
		type = src.getType();
		if (src.getValueList() != null){
			valueList = new ArrayList<>();
			for (String value : src.getValueList()){
				valueList.add(value);
			}
		}
		defaultValue = src.getDefaultValue();
		validationType = src.getValidationType();
		validationHelp = src.getValidationHelp();
		validationRegex = src.getValidationRegex();
		columnTypeFilter = src.getColumnTypeFilter();
		minValue = src.getMinValue();
		maxValue = src.getMaxValue();
	}
    @Schema(description="Parameter description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Schema(description="Type of parameter",
            allowableValues={AlgorithmParameter.TEXT_TYPE,
                             AlgorithmParameter.DROPDOWN_TYPE,
			                 AlgorithmParameter.RADIO_TYPE,
			                 AlgorithmParameter.CHECKBOX_TYPE,
			                 AlgorithmParameter.NODECOLUMN_TYPE,
			                 AlgorithmParameter.EDGECOLUMN_TYPE,
			                 AlgorithmParameter.FLAG_TYPE})
    public String getType() {
        return type;
    }

    public void setType(String type) throws CytoContainerException {
		if (type != null && !TYPE_SET.contains(type)){
			throw new CytoContainerException(type + " is not a valid type");
		}
        this.type = type;
    }

    @Schema(description="Default value for parameter")
    public String getDefaultValue() {
        return defaultValue;
    }

    
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

	@Schema(description="Values to put into '" + AlgorithmParameter.DROPDOWN_TYPE + "' type field")
	public List<String> getValueList() {
		return valueList;
	}

	public void setValueList(List<String> valueList) {
		this.valueList = valueList;
	}

    @Schema(description="Display name for parameter")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /*
                + " 'number' only allows floating point number or numbers with decimals\n"
            + " 'digits' is whole numbers and can include - for negative\n"
            + " Both 'number' and 'digits' can be limited by 'minValue' and 'maxValue'"
            + "'string' allows ASCI characters and can be limited by 'validationRegex'")

    */
    @Schema(description="Type of validation to perform",
            allowableValues={AlgorithmParameter.NUMBER_VALIDATION,
                AlgorithmParameter.DIGITS_VALIDATION,
                AlgorithmParameter.STRING_VALIDATION})
    public String getValidationType() {
        return validationType;
    }

    public void setValidationType(String validationType) throws CytoContainerException {
		if (validationType != null && !VALIDATION_SET.contains(validationType)){
			throw new CytoContainerException(validationType + " is not a valid validationType");
		}
        this.validationType = validationType;
    }

    @Schema(description="Text to display if validation fails")
    public String getValidationHelp() {
        return validationHelp;
    }

    public void setValidationHelp(String validationHelp) {
        this.validationHelp = validationHelp;
    }

    @Schema(description="Regular expression that is applied to parameters"
            + "of 'type' string")
    public String getValidationRegex() {
        return validationRegex;
    }

    public void setValidationRegex(String validationRegex) {
        this.validationRegex = validationRegex;
    }

    @Schema(description="If set and parameter is of type '" +
            AlgorithmParameter.NUMBER_VALIDATION + "' or '" +
            AlgorithmParameter.DIGITS_VALIDATION + "', "
            + " values below this should NOT be allowed")
    public Number getMinValue() {
        return minValue;
    }

    public void setMinValue(Number minValue) {
        this.minValue = minValue;
    }

    @Schema(description="If set and parameter is of type '" +
            AlgorithmParameter.NUMBER_VALIDATION + "' or '" +
            AlgorithmParameter.DIGITS_VALIDATION + "', "
            + " values above this should NOT be allowed")
    public Number getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Number maxValue) {
        this.maxValue = maxValue;
    }

	@Schema(description="Only used for nodes/edges column type. If defined, Cytoscape Web uses it to filter what node/edge columns to display. If omitted, all columns will be listed",
			allowableValues = {CXDataType.LIST_OF, CXDataType.NUMBER, CXDataType.WHOLE_NUMBER,CXDataType.LIST_OF_NUMBER, CXDataType.LIST_OF_WHOLE_NUMBER, CXDataType.STRING_TYPE, CXDataType.LONG_TYPE, CXDataType.INTEGER_TYPE, CXDataType.DOUBLE_TYPE, CXDataType.BOOLEAN_TYPE,
				CXDataType.LIST_OF_STRING_TYPE, CXDataType.LIST_OF_LONG_TYPE, CXDataType.LIST_OF_INTEGER_TYPE, CXDataType.LIST_OF_DOUBLE_TYPE, CXDataType.LIST_OF_BOOLEAN_TYPE
			})
	public String getColumnTypeFilter() {
		return columnTypeFilter;
	}

	public void setColumnTypeFilter(String columnTypeFilter) throws CytoContainerException {
		if (columnTypeFilter != null && !CXDataType.COLUMN_FILTER_SET.contains(columnTypeFilter)){
			throw new CytoContainerException(columnTypeFilter + " is not a valid columnTypeFilter");
		}
		this.columnTypeFilter = columnTypeFilter;
	}
	
	
}
