package com.atguigu.project1;

import java.util.*;

/**
 * Utility class
 *
 * @author jiazhikai
 * @date 2021/4/25
 */
public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 用于界面菜单的选择
     * @return
     */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.print("选择错误，请重新输入");
            } else{
                break;
            }
        }
        return c;
    }

    /**
     * 用于收入和支出金额的输入
     * @return
     */
    public static int readNumber() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(4);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入");
            }
        }
        return n;
    }

    /**
     * 用于收入和支出说明的输入
     * @return
     */
    public static String readString() {
        String str = readKeyBoard(8);
        return str;
    }

    /**
     * 用于确认选择的输入
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入");
            }
        }
        return c;
    }

    /**
     * 键盘输入限制长度
     * @param limit
     * @return
     */
    private static String readKeyBoard(int limit) {
        String line = "";

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("���볤�ȣ�������" + limit + "���������������룺");
                continue;
            }
            break;
        }

        return line;
    }
}
