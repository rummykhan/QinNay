package Selio.TestCase;


import Selio.Form.FormInput;

import java.util.HashMap;
import java.util.Map;

public abstract class FormTestCase extends TestCase {

    protected Map<String, FormInput> inputs;
    protected Map<String, String> successHeaders;
    protected String successText = null;

    public abstract String getSubmitButtonSelector();

    public Map<String, FormInput> getInputs() {

        if (inputs.size() == 0) {
            fillInputs();
        }

        return inputs;
    }

    public abstract void fillInputs();

    public abstract String getSuccessUrl();

    public abstract String getSuccessCode();

    public Map<String, String> getSuccessHeaders() {
        return new HashMap<String, String>();
    }

    public String getSuccessText() {
        return successText;
    }

    @Override
    public void run() {
        this.visit();
    }
}
