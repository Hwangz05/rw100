public class Position {
    private int positionId;
    private PositionName positionName;

    public Position() {
    }

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

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

        public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }
}