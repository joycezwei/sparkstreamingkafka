package com.st.zsjspark.model;

public class Original {
    private Integer id;

    private String machineCode;

    private String key;

    private String value;

    private Long time;
    
    private Integer groupId;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "Original [id=" + id + ", machineCode=" + machineCode + ", key="
				+ key + ", value=" + value + ", time=" + time + ", groupId="
				+ groupId + "]";
	}

}