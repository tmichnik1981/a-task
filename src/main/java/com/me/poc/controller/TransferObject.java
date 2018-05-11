package com.me.poc.controller;

import com.me.poc.domain.Player;
import com.me.poc.view.ViewModel;

public class TransferObject {

    private final View view;
    private final boolean redirect;
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

    public TransferObject(TransferObjectBuilder builder) {
        this.view = builder.view;
        this.redirect = builder.redirect;
        this.viewModel = builder.viewModel;
    }
    public static TransferObjectBuilder builder() {
        return new TransferObjectBuilder();
    }

    public  static class TransferObjectBuilder{
        private View view;
        private boolean redirect;
        private ViewModel viewModel;

        public TransferObjectBuilder withView(View view){
            this.view = view;
            return this;
        }

        public TransferObjectBuilder withRedirect(boolean redirect){
            this.redirect = redirect;
            return this;
        }
        public TransferObjectBuilder withViewModel(ViewModel viewModel){
            this.viewModel = viewModel;
            return this;
        }

        public TransferObject build() {
            return new TransferObject(this);
        }

    }
}
