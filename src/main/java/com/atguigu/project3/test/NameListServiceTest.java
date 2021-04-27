package com.atguigu.project3.test;

import com.atguigu.project3.exception.TeamException;
import com.atguigu.project3.model.personal.Employee;
import com.atguigu.project3.service.NameListService;
import org.junit.Test;

/**
 * NameListServiceTest class
 *
 * @author jiazhikai
 * @date 2021/4/27
 */
public class NameListServiceTest {
   @Test
   public void testGetAllEmployees(){
       NameListService service = new NameListService();
       Employee[] employees = service.getAllEmployees();
       for (int i = 0; i < employees.length; i++) {
           System.out.println(employees[i]);
       }
   }
   @Test
    public void testGetEmployee(){
       NameListService service = new NameListService();
       try {

           System.out.println(service.getEmployee(10));
       } catch (TeamException e) {
           System.out.println(e.getMessage());
       }
   }
}
