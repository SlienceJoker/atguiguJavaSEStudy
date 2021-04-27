package com.atguigu.project3.model.equipment;

/**
 * PC class
 *
 * @author jiazhikai
 * @date 2021/4/26
 */
public class PersonalComputer implements Equipment {
    /**
     * model 机器型号
     * display 显示器名称
     */
    private String model;
    private String display;

    public PersonalComputer() {
    }

    public PersonalComputer(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model+"("+display+")";
    }
}
