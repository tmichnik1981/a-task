package com.me.poc.controller;

import com.me.poc.view.ViewModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TransferObject {

    private final View view;
    private final boolean redirect;
    private final Map<String, String> transferParams;
    private final ViewModel viewModel;

    public View getView() {
        return view;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    public Map<String, String> getTransferParams() {
        return Collections.unmodifiableMap(transferParams);
    }

    public TransferObject(TransferObjectBuilder builder) {
        this.view = builder.view;
        this.redirect = builder.redirect;
        this.viewModel = builder.viewModel;
        this.transferParams = builder.transferParams;
    }

    public static TransferObjectBuilder builder() {
        return new TransferObjectBuilder();
    }

    public static class TransferObjectBuilder {
        private View view;
        private boolean redirect;
        private ViewModel viewModel;
        private Map<String, String> transferParams = new HashMap<>();

        public TransferObjectBuilder withView(View view) {
            this.view = view;
            return this;
        }

        public TransferObjectBuilder withRedirect(boolean redirect) {
            this.redirect = redirect;
            return this;
        }

        public TransferObjectBuilder withViewModel(ViewModel viewModel) {
            this.viewModel = viewModel;
            return this;
        }

        public TransferObjectBuilder withTransferParam(String key, String value) {
            this.transferParams.put(key, value);
            return this;
        }

        public TransferObject build() {
            return new TransferObject(this);
        }

    }
}
