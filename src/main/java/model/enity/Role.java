package model.enity;

public enum Role {
    UNREGISTERED(1),
    USER(2),
    EMPLOYEE(3),
    MANAGER(4);

    private int accessLevel;

    Role(int accessLevel){
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel(){
        return accessLevel;
    }
}
