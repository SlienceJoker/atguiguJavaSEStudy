package com.atguigu.project3.ui;

import com.atguigu.project3.exception.TeamException;
import com.atguigu.project3.model.personal.Employee;
import com.atguigu.project3.model.personal.Programmer;
import com.atguigu.project3.service.NameListService;
import com.atguigu.project3.service.TeamService;
import com.atguigu.project3.util.TeamCmsUtility;

/**
 * TeamView class
 *
 * @author jiazhikai
 * @date 2021/4/27
 */
public class TeamView {
    /**
     * listSvc和teamSvc属性：供类中的方法使用
     */
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    /**
     * 主界面显示及控制方法
     */
    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu=0;
        while (loopFlag) {
            if (menu != '1'){
                listAllEmployees();
            }
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
            menu = TeamCmsUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("是否确认退出(Y/N):");
                    char isExit = TeamCmsUtility.readConfirmSelection();
                    if (isExit=='Y'){
                        loopFlag=false;
                    }
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 以表格形式列出公司所有成员
     */
    public void listAllEmployees() {
        System.out.println("开发团队调度软件");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees==null||employees.length==0){
            System.out.println("公司中没有任何员工信息!");
        }else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
        System.out.println();
    }

    /**
     * 显示团队成员列表操作
     */
    public void getTeam() {
        System.out.println("开发团队成员列表");
        Programmer[] team= teamSvc.getTeam();
        if (team==null||team.length==0){
            System.out.println("目前团队没有成员");
        }else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }

        System.out.println();
    }

    /**
     * 实现添加成员操作
     */
    public void addMember() {
        System.out.println("添加团队成员");
        System.out.print("请输入要添加的员工ID:");
        int id = TeamCmsUtility.readInt();
        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException teamException) {
            System.out.println("添加失败，原因为："+teamException.getMessage());
        }
        //按回车继续
        TeamCmsUtility.readReturn();
    }

    /**
     * 实现删除成员操作
     */
    public void deleteMember() {
        System.out.println("删除团队成员");
        System.out.print("请输入要删除的员工的TID：");
        int memberId = TeamCmsUtility.readInt();
        System.out.print("确认是否删除(Y/N):");
        char isDelete =TeamCmsUtility.readConfirmSelection();
        if (isDelete=='N'){
            return;
        }
        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因为："+e.getMessage());
        }
        TeamCmsUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
