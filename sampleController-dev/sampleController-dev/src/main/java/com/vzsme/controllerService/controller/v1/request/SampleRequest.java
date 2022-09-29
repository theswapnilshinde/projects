package com.vzsme.controllerService.controller.v1.request;

import com.vzsme.controllerService.model.DbInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

public class SampleRequest {
    @NotNull(message = "is required")
    public Integer runId;

    @NotEmpty(message = "is required")
    @Valid public List<String> list;

    @NotNull(message = "is required")
    @Valid public DbInfo dbInfo;

    public void validateInput() {
        //throw new InvalidInputException(">>> TESTING <<<<<");
    }
}

