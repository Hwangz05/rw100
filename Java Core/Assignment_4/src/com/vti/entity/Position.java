package com.vti.entity;

public class Position {
    private int positionId;
    private PositionName positionName;



    public enum PositionName {
        DEV, TEST, SCRUM_MASTER, PM
    }

    public Position(int positionId, PositionName positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public PositionName getPositionName() {
        return positionName;
    }
}