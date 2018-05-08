package com.st.zsjspark.model;

public class Workset {

	private String worksetid;

    private String worksetname;

    private String context;

    public String getWorksetid() {
        return worksetid;
    }

    public void setWorksetid(String worksetid) {
        this.worksetid = worksetid;
    }

    public String getWorksetname() {
        return worksetname;
    }

    public void setWorksetname(String worksetname) {
        this.worksetname = worksetname;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    
    @Override
	public String toString() {
		return "Workset [worksetid=" + worksetid + ", worksetname="
				+ worksetname + ", context=" + context + "]";
	}
}