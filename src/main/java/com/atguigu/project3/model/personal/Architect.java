package com.atguigu.project3.model.personal;

import com.atguigu.project3.model.equipment.Equipment;

/**
 * Architect class
 *
 * @author jiazhikai
 * @date 2021/4/26
 */
public class Architect extends Designer{
    private int stock;
    public Architect(){super();}
    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+stock+getEquipment().getDescription();
    }
    @Override
    public String getDetailsForTeam(){
        return getMemberId()+"\\"+getDetails()+"\t架构师\t"+getBonus()+"\t"+getStock();
    }
}
