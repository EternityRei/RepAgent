package model.enity;

public enum WorkStatus {

    NOT_STARTED(1),
    IN_PROCCESS(2),
    DONE(3);

    private int workStatus;

    WorkStatus(int workStatus){
        this.workStatus = workStatus;
    }
}
