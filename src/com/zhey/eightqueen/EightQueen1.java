package com.zhey.eightqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhey on 17-6-18.
 */
public class EightQueen1 {
    private int size;
    private int[] row;
    private int[] result;
    private int resultCount = 0;
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public EightQueen1(int size) {
        this.size = size;
        row = new int[size];
        result = new int[size];
        for (int i = 0; i < size; i++) {
            row[i] = 1;
        }
    }

    public void function(int level) {
        if (level == size - 1) {
            for (int index = 0; index < size; index++) {
                if (canSet(level, index)) {
                    result[level] = index;
                    list.add(Arrays.toString(result));
                    resultCount++;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (canSet(level, index)) {
                    result[level] = index;
                    function(level + 1);
                }
            }
        }
    }

    private boolean canSet(int level, int pos) {
        for (int index = 0; index < level; index++) {
            if (result[index] == pos) {
                return false;
            } else if (Math.abs(level - index) == Math.abs(pos -
                    result[index])) {
                return false;
            }
        }
        return true;
    }

    public void getResult() {
        function(0);
        System.out.println("result count:" + resultCount);
    }

    public static void main(String[] args) {
        EightQueen1 eightQueen1 = new EightQueen1(8);
        eightQueen1.getResult();
    }
}
