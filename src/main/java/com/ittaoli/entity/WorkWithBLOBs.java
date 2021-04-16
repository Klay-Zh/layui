package com.ittaoli.entity;

public class WorkWithBLOBs extends Work {
    private String inspectR;

    private String serverProj;

    public String getInspectR() {
        return inspectR;
    }

    public void setInspectR(String inspectR) {
        this.inspectR = inspectR == null ? null : inspectR.trim();
    }

    public String getServerProj() {
        return serverProj;
    }

    public void setServerProj(String serverProj) {
        this.serverProj = serverProj == null ? null : serverProj.trim();
    }
}