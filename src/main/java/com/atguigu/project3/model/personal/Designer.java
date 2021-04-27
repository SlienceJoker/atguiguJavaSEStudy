package com.atguigu.project3.model.personal;

import com.atguigu.project3.model.equipment.Equipment;

/**
 * Designer class
 *
 * @author jiazhikai
 * @date 2021/4/26
 */
public class Designer extends Programmer {
    private double bonus;
    public Designer(){super();}
    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }



    @Override
    public String toString() {
        return getDetails()+"\t设计师\t"+getStatus()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    @Override
    public String getDetailsForTeam(){
        return getMemberId()+"\\"+getDetails()+"\t设计师\t"+getBonus();
    }
}
