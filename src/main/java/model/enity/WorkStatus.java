package model.enity;

public enum WorkStatus {
    IN_PROCCESS(1),
    DONE(2);

    private int workStatus;

    WorkStatus(int workStatus){
        this.workStatus = workStatus;
    }
}
