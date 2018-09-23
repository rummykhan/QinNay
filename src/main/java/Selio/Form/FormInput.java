package Selio.Form;

public class FormInput {

    private InputType inputType;
    private String value;

    public FormInput(InputType inputType, String value) {
        this.inputType = inputType;
        this.value = value;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
