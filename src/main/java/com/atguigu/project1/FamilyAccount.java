package com.atguigu.project1;


/**
 * FamilyAccount class
 *
 * @author jiazhikai
 * @date 2021/4/25
 */
public class FamilyAccount {
    public static void main(String[] args) {
        boolean isFlag = true;
        //用于记录用户收入和支出详情
        String details = "";
        //初始金额
        int balance = 10000;
        while (isFlag) {
            System.out.println("家庭收支记账软件\n");
            System.out.println("1.收支明细");
            System.out.println("2.登记收入");
            System.out.println("3.登记支出");
            System.out.println("4.退   出\n");
            System.out.println("请输入<1-4>");
            //获取用户的选择
            char selection = Utility.readMenuSelection();
            switch (selection) {
                case '1':
                    System.out.println("当前收支明细记录");
                    System.out.println("收支\t账户金额\t收支金额\t说明\n");
                    System.out.println(details);
                    System.out.println("--------------");
                    break;
                case '2':
                    System.out.print("本次输入金融");
                    int inMoney = Utility.readNumber();
                    System.out.println("本次收入说明");
                    String inInfo = Utility.readString();
                    System.out.println("登记完成");
                    //处理balance
                    balance += inMoney;
                    //处理details
                    details += ("收入\t" + balance + "\t" + inMoney + "\t" + inInfo + "\n");
                    break;
                case '3':
                    System.out.println("本次支出金额：");
                    int outMoney = Utility.readNumber();
                    System.out.println("本次支出说明：");
                    String outInfo = Utility.readString();
                    //处理balance
                    if (balance >= outMoney) {
                        balance -= outMoney;
                        details += ("支出\t" + balance + "\t" + outMoney + "\t" + outInfo + "\n");
                    } else {
                        System.out.println("支出超出账户额度，支付失败");
                    }
                    System.out.println("登记完成");
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                default:
                    break;
            }


            //isFlag = false;
        }
    }
}
