package com.vti.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Group {
    private int groupId;
    private String groupName;
    private Account creator;
    private LocalDateTime createDate;
    private List<Account> accounts;

    public Group() {
    }

    public Group(int groupId, String groupName, Account creator, LocalDateTime createDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}