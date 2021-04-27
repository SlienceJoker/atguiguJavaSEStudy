package com.atguigu.project2.ui;

import com.atguigu.project2.model.Customer;
import com.atguigu.project2.service.CustomerList;
import com.atguigu.project2.util.CustomerManageUtility;

/**
 * CustomerView class
 * 主模块，负责菜单的显示和处理用户操作
 *
 * @author jiazhikai
 * @date 2021/4/26
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("123", '男', 23, "12345678901", "test@qq.com");
        customerList.addCustomer(customer);
    }

    /**
     * 用途：显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理。
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        do {
            System.out.println("客户信息管理软件");
            System.out.println("1.添加客户");
            System.out.println("2.修改客户");
            System.out.println("3.删除客户");
            System.out.println("4.客户列表");
            System.out.println("5.退出\n");
            System.out.print("请选择(1-5):");
            char menu = CustomerManageUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N)");
                    char isExit = CustomerManageUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
                default:
                    break;
            }
        } while (isFlag);
    }

    /**
     * 添加客户
     */
    private void addNewCustomer() {
        System.out.println("添加客户");
        System.out.print("姓名：");
        String name = CustomerManageUtility.readString(10);
        System.out.print("性别：");
        char gender = CustomerManageUtility.readChar();
        System.out.print("年龄：");
        int age = CustomerManageUtility.readInt();
        System.out.print("电话：");
        String phone = CustomerManageUtility.readString(13);
        System.out.print("邮箱：");
        String email = CustomerManageUtility.readString(30);
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("添加完成");
        } else {
            System.out.println("客户目录已满，添加失败");
        }

    }

    /**
     * 修改客户
     */
    private void modifyCustomer() {
        System.out.println("修改客户");
        Customer cust;
        int number;
        for (; ; ) {
            System.out.print("请选择待修改客户的编号(-1退出)：");
            number = CustomerManageUtility.readInt();
            if (number == -1) {
                return;
            }
            cust = customerList.getCustomer(number - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户!");
            } else {
                break;
            }
        }
        //修改客户信息
        System.out.print("姓名(" + cust.getName() + "):");
        String name = CustomerManageUtility.readString(10, cust.getName());
        System.out.print("性别(" + cust.getGender() + "):");
        char gender = CustomerManageUtility.readChar(cust.getGender());
        System.out.print("年龄(" + cust.getAge() + "):");
        int age = CustomerManageUtility.readInt(cust.getAge());
        System.out.print("电话(" + cust.getPhone() + "):");
        String phone = CustomerManageUtility.readString(11, cust.getPhone());
        System.out.print("邮箱(" + cust.getEmail() + "):");
        String email = CustomerManageUtility.readString(30, cust.getEmail());
        Customer newCust = new Customer(name, gender, age, phone, email);

        boolean isReplaced= customerList.replaceCustomer(number - 1, newCust);
        if (isReplaced){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    /**
     * 删除客户
     */
    private void deleteCustomer() {
        System.out.println("删除客户");
        Customer cust;
        int number;
        for (; ; ) {
            System.out.print("请选择待删除客户的编号(-1退出)：");
            number = CustomerManageUtility.readInt();
            if (number == -1) {
                return;
            }
            cust = customerList.getCustomer(number - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户!");
            } else {
                break;
            }
        }
        System.out.print("确认是否删除(Y/N):");
        char isDel = CustomerManageUtility.readChar();
        if (isDel=='Y'){
            boolean isDelete= customerList.deleteCustomer(number-1);
            if (isDelete){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
                return;
            }
        }else {
            return;
        }

    }

    /**
     * 客户列表
     */
    private void listAllCustomers() {
        System.out.println("客户列表");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱\t");
            Customer[] customers = customerList.getAllCustomers();
            for (int i = 0; i < customers.length; i++) {
                Customer cust = customers[i];
                System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }

        System.out.println("客户列表完成");

    }

    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

}
