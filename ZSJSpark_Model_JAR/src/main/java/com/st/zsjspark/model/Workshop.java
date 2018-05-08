package com.st.zsjspark.model;

import java.io.Serializable;
import java.util.Arrays;

public class Workshop {
    private Integer id;

    private String workshopname;
    
    private String workshopfzr;
    
    private String phone;
    
	private Integer workshopnums;

    private String remark;
    
    private Integer status;
    
    private Serializable[] ids;
    
	public Serializable[] getIds() {
		return ids;
	}

	public void setIds(Serializable[] ids) {
		this.ids = ids;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
    public String getWorkshopfzr() {
		return workshopfzr;
	}

	public void setWorkshopfzr(String workshopfzr) {
		this.workshopfzr = workshopfzr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getWorkshopnums() {
		return workshopnums;
	}

	public void setWorkshopnums(Integer workshopnums) {
		this.workshopnums = workshopnums;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getWorkshopname() {
        return workshopname;
    }

    public void setWorkshopname(String workshopname) {
        this.workshopname = workshopname;
    }
    
    @Override
	public String toString() {
		return "Workshop [id=" + id + ", workshopname=" + workshopname
				+ ", workshopfzr=" + workshopfzr + ", phone=" + phone
				+ ", workshopnums=" + workshopnums + ", remark=" + remark
				+ ", status=" + status + ", ids=" + Arrays.toString(ids) + "]";
	}
}