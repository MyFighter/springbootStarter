package com.springboot.starter;

import org.springframework.core.DefaultParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class InvokeTest {

    public static int maximalSquare(char[][] matrix) {
        int area = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]=='1'){
                    int tempArea = 1;

                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Method[] methods = InvokeTest.class.getMethods();
        DefaultParameterNameDiscoverer dpnd = new DefaultParameterNameDiscoverer();
        for (Method m : methods){
            if ("maximalSquare".equals(m.getName())){
                String[] parameterNames = dpnd.getParameterNames(m);
                System.out.println(parameterNames);
            }
        }
    }
}
