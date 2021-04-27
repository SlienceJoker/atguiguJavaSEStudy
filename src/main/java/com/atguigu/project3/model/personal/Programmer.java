package com.atguigu.project3.model.personal;


import com.atguigu.project3.model.equipment.Equipment;
import com.atguigu.project3.service.Status;

/**
 * Programmer class
 *
 * @author jiazhikai
 * @date 2021/4/26
 */
public class Programmer extends Employee{
    private int memberId;
    private Status status=Status.FREE;
    private Equipment equipment;

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.status=status;
        this.equipment = equipment;
    }

    @Override
    public String toString() {

        return getDetails()+"\t程序员\t"+status + "\t\t\t"+equipment.getDescription();
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getDetailsForTeam(){
        return memberId+"/"+getDetails();
    }
}
