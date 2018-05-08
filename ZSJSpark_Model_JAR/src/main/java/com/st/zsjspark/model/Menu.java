package com.st.zsjspark.model;

public class Menu {

	private String menuid;

    private String menuname;

    private String url;

    private String parentmenu;
 
    private String icon;
    
    private String check;

    public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentmenu() {
        return parentmenu;
    }

    public void setParentmenu(String parentmenu) {
        this.parentmenu = parentmenu;
    }
    
    @Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", menuname=" + menuname + ", url="
				+ url + ", parentmenu=" + parentmenu + ", icon=" + icon
				+ ", check=" + check + "]";
	}
}