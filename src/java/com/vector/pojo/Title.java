package com.vector.pojo;
// Generated 2018-5-26 16:13:05 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

/**
 * Title generated by hbm2java
 */
public class Title implements java.io.Serializable {

    private int titleId;
    private String titleName;
    private String titleDescription;
    @JsonIgnore
    private Set<Staff> staffs = new HashSet<Staff>(0);

    public Title() {
    }

    public Title(int titleId, String titleName, String titleDescription) {
        this.titleId = titleId;
        this.titleName = titleName;
        this.titleDescription = titleDescription;
    }

    public Title(int titleId, String titleName, String titleDescription, Set<Staff> staffs) {
        this.titleId = titleId;
        this.titleName = titleName;
        this.titleDescription = titleDescription;
        this.staffs = staffs;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleDescription() {
        return this.titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    public Set<Staff> getStaffs() {
        return this.staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

}
