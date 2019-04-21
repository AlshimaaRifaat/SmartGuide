package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.LoginData;

public interface LoginView {
    void showLoginResult(LoginData loginData);
    void showError();
}
