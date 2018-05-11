package com.me.poc.service;

import com.me.poc.controller.TransferObject;

import java.util.Map;

public interface ApplicationService {

    TransferObject handle(Map<String, String> requestParams);
}
