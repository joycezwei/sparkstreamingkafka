package com.st.zsjspark.model;

import java.util.Arrays;

public class MachineObject {
    private String machineName;

    private byte[] machineObject;

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName == null ? null : machineName.trim();
    }

    public byte[] getMachineObject() {
        return machineObject;
    }

    public void setMachineObject(byte[] machineObject) {
        this.machineObject = machineObject;
    }

	@Override
	public String toString() {
		return "MachineObject [machineName=" + machineName + ", machineObject="
				+ Arrays.toString(machineObject) + "]";
	}
}