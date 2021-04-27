package com.atguigu.project3.model.equipment;

/**
 * NoteBook class
 *
 * @author jiazhikai
 * @date 2021/4/26
 */
public class NoteBook implements Equipment{

    private String model;
    private double price;

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model+"("+price+")";
    }
}
