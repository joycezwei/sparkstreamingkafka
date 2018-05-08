package com.st.zsjspark.model;

public class MachineHistory {

	private Integer id;

    private String machineCode;

    private Double cycleTime;

    private Integer openModelNum;

    private Long updateTime;
    
    public MachineHistory(){
    	
    }

    public MachineHistory(String machineCode, Double cycleTime, Integer openModelNum, Long updateTime) {
		this.machineCode = machineCode;
		this.cycleTime = cycleTime;
		this.openModelNum = openModelNum;
		this.updateTime = updateTime;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmachineCode() {
        return machineCode;
    }

    public void setmachineCode(String machineCode) {
        this.machineCode = machineCode == null ? null : machineCode.trim();
    }

    public Double getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(Double cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Integer getOpenModelNum() {
        return openModelNum;
    }

    public void setOpenModelNum(Integer openModelNum) {
        this.openModelNum = openModelNum;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
	public String toString() {
		return "MachineHistory [id=" + id + ", machineCode=" + machineCode
				+ ", cycleTime=" + cycleTime + ", openModelNum=" + openModelNum
				+ ", updateTime=" + updateTime + "]";
	}
}