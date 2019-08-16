package com.herculis.tags;

import com.herculis.html.FormMethod;
import com.herculis.html.HtmlFormats;

import java.util.ArrayList;
import java.util.List;

public class Form {

    private String action;

    private FormMethod method;

    private List<Input> inputs;

    public static final class FormBuilder {

        private String action;

        private FormMethod method;

        private List<Input> inputs;

        private FormBuilder() {
            this.inputs = new ArrayList<Input>();
        }

        public static FormBuilder getInstance() {
            return new FormBuilder();
        }

        public FormBuilder addAction(String action) {
            this.action = action;
            return this;
        }

        public FormBuilder addMethod(FormMethod method) {
            this.method = method;
            return this;
        }

        public FormBuilder addInput(Input input) {
            this.inputs.add(input);
            return this;
        }

        public Form build() {
            Form form = new Form();
            form.inputs = this.inputs;
            form.action = this.action;
            form.method = this.method;
            return form;
        }
    }

    @Override
    public String toString() {
        String inputListAsString = "";
        for(Input item : this.inputs) {
            inputListAsString = inputListAsString.concat(item.toString());
        }

        return String.format(HtmlFormats.DEFAULT_3D_FORM_FORMAT, this.method.name(), this.action, inputListAsString);
    }
}
