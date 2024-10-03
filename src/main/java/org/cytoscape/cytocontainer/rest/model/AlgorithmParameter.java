package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlgorithmParameter {
    
	public static final String TEXT_TYPE = "text";
	public static final String DROPDOWN_TYPE = "dropDown";
	public static final String RADIO_TYPE = "radio";
	public static final String CHECKBOX_TYPE = "checkBox";
	public static final String NODECOLUMN_TYPE = "nodeColumn";
	public static final String EDGECOLUMN_TYPE = "edgeColumn";
	
    public static final String FLAG_TYPE = "checkBox";
    
    public static final String NUMBER_VALIDATION = "number";
    public static final String DIGITS_VALIDATION = "digits";
    public static final String STRING_VALIDATION = "string";
    
    private String displayName;
    private String description;
    private String type;
	private List<String> valueList;
    private String defaultValue;
    private String validationType;
    private String validationHelp;
    private String validationRegex;
    private Number minValue;
    private Number maxValue;
   

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
			                 AlgorithmParameter.EDGECOLUMN_TYPE})
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Schema(description="Default value for parameter, for ")
    public String getDefaultValue() {
        return defaultValue;
    }

    
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

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

    public void setValidationType(String validationType) {
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
}
