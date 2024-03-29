package com.atguigu.project3.service;

import com.atguigu.project3.exception.TeamException;
import com.atguigu.project3.model.equipment.Equipment;
import com.atguigu.project3.model.equipment.NoteBook;
import com.atguigu.project3.model.equipment.PersonalComputer;
import com.atguigu.project3.model.equipment.Printer;
import com.atguigu.project3.model.personal.Architect;
import com.atguigu.project3.model.personal.Designer;
import com.atguigu.project3.model.personal.Employee;
import com.atguigu.project3.model.personal.Programmer;

import static com.atguigu.project3.service.Data.*;


/**
 * NameListService class
 *
 * @author jiazhikai
 * @Descroption 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * @date 2021/4/26
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            //获取员工的类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的4个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            Double bonus;
            int stock;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 获取指定index的员工的设备
     *
     * @param index
     * @return
     */
    private Equipment createEquipment(int index) {
        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        String modelOrName = EQUIPMENTS[index][1];
        String info = EQUIPMENTS[index][2];
        switch (key) {
            case PC:
                return new PersonalComputer(modelOrName, info);
            case NOTEBOOK:
                double price = Double.parseDouble(info);
                return new NoteBook(modelOrName, price);
            case PRINTER:
                return new Printer(modelOrName, info);
            default:
                break;
        }
        return null;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定id的员工
     *
     * @param id
     * @return
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        System.out.println(employees);
    }
}
