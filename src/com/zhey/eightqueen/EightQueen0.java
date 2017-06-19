package com.zhey.eightqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhey on 17-6-18.
 */
public class EightQueen0 {

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

    public EightQueen0(int size) {
        this.size = size;
        row = new int[size];
        result = new int[size];
        for (int i = 0; i < size; i++) {
            row[i] = 1;
        }
    }

    public void function(int level) {
        int[] currentRow = new int[size];
        for (int i = 0; i < size; i++) {
            currentRow[i] = 1;
        }
        setZero(currentRow, level);
        //判断退出
        if (level == size - 1) {
            for (int index = 0; index < size; index++) {
                if (currentRow[index] == 1) {
                    result[level] = index;
                    currentRow[index] = 0;
                    list.add(Arrays.toString(result));
                    resultCount++;
                }
            }
        } else {

            for (int index = 0; index < size; index++) {
                if (currentRow[index] == 1) {
                    result[level] = index;
                    function(level + 1);
                }
            }
        }
    }

    private void setZero(int[] tmp, int level) {
        int line = level;
        int currentColumn;
        int currentRow;
        int row;
        if (level == 4) {
            line = level;
        }
        for (int i = 0; i < level; i++) {
            tmp[result[i]] = 0;
        }
        //右斜线和本行交叉的位置
        for (int i = 0; i < level; i++) {
            currentColumn = result[i] + level - i;
            if (currentColumn < size) {
                tmp[currentColumn] = 0;
            }
        }
        //左斜线和本行交叉的位置
        for (int i = 0; i < level; i++) {
            currentColumn = result[i] - level + i;
            if (currentColumn >= 0) {
                tmp[currentColumn] = 0;
            }
        }
    }

    public void getResult() {
        function(0);
        System.out.println("result count:" + resultCount);
    }

    public static void main(String[] args) {
        EightQueen0 eightQueen0 = new EightQueen0(8);
        eightQueen0.getResult();
    }
}
