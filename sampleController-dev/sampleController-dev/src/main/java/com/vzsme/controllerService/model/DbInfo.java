package com.vzsme.controllerService.model;

import javax.validation.constraints.NotEmpty;

public class DbInfo {
    @NotEmpty//(message = "is required")
    public String dbUrl;

    @NotEmpty//(message = "is required")
    public String dbUsr;

    @NotEmpty//(message = "is required")
    public String dbPwd;
}
