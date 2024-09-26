package org.cytoscape.cytocontainer.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author churas
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlgorithmCustomParameter {
    
    public static final String VALUE_TYPE = "value";
    public static final String FLAG_TYPE = "flag";
    
    public static final String NUMBER_VALIDATION = "number";
    public static final String DIGITS_VALIDATION = "digits";
    public static final String STRING_VALIDATION = "string";
    
    private String _name;
    private String description;
    private String type;
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
            allowableValues={AlgorithmCustomParameter.VALUE_TYPE,
                             AlgorithmCustomParameter.FLAG_TYPE})
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

    @Schema(description="Name for parameter")
    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    /*
                + " 'number' only allows floating point number or numbers with decimals\n"
            + " 'digits' is whole numbers and can include - for negative\n"
            + " Both 'number' and 'digits' can be limited by 'minValue' and 'maxValue'"
            + "'string' allows ASCI characters and can be limited by 'validationRegex'")

    */
    @Schema(description="Type of validation to perform",
            allowableValues={AlgorithmCustomParameter.NUMBER_VALIDATION,
                AlgorithmCustomParameter.DIGITS_VALIDATION,
                AlgorithmCustomParameter.STRING_VALIDATION})
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
            AlgorithmCustomParameter.NUMBER_VALIDATION + "' or '" +
            AlgorithmCustomParameter.DIGITS_VALIDATION + "', "
            + " values below this should NOT be allowed")
    public Number getMinValue() {
        return minValue;
    }

    public void setMinValue(Number minValue) {
        this.minValue = minValue;
    }

    @Schema(description="If set and parameter is of type '" +
            AlgorithmCustomParameter.NUMBER_VALIDATION + "' or '" +
            AlgorithmCustomParameter.DIGITS_VALIDATION + "', "
            + " values above this should NOT be allowed")
    public Number getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Number maxValue) {
        this.maxValue = maxValue;
    }
}
