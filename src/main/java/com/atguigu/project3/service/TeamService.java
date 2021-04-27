package com.atguigu.project3.service;

import com.atguigu.project3.exception.TeamException;
import com.atguigu.project3.model.personal.Architect;
import com.atguigu.project3.model.personal.Designer;
import com.atguigu.project3.model.personal.Employee;
import com.atguigu.project3.model.personal.Programmer;

/**
 * TeamService class
 * 关于开发团队成员的管理：添加、删除等。
 *
 * @author jiazhikai
 * @date 2021/4/27
 */
public class TeamService {
    /**
     * counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
     * MAX_MEMBER：表示开发团队最大成员数
     * team数组：用来保存当前团队中的各成员对象
     * total：记录团队成员的实际人数
     */
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public TeamService() {
        super();
    }

    /**
     * 返回当前团队的所有对象
     *
     * @return 包含所有成员对象的数组，数组大小与成员人数一致
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 向团队中添加成员
     *
     * @param e 待添加成员的对象
     * @throws TeamException 添加失败， TeamException中包含了失败原因
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
        //强转 此步骤一定不会出现ClassCastException
        Programmer p = (Programmer) e;
        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("该员工已是某团队成员");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("该员工正在休假，无法添加");
        }
        //获取team中已有成员中架构师、设计师、程序员的人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }
        //将p或e添加到现有的team中
        team[total++] = p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    /**
     * 员工是否在团队中
     *
     * @param e
     * @return
     */
    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从团队中删除成员
     *
     * @param memberId 待删除成员的memberId
     * @throws TeamException 找不到指定memberId的员工，删除失败
     */
    public void removeMember(int memberId) throws TeamException {
        int i=0;
        for (; i < total; i++) {
            if (team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i==total){
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        for (int j = i+1; j < total; j++) {
            team[j-1] = team[i];
        }
        /*
         team[total-1]=null;
         total--;
        */
        team[--total]=null;

    }
}
