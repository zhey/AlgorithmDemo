package com.zhey.eightqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhey on 17-6-18.
 */
public class EightQueen {

    private int size = 8;
    private int[] checkerboard = new int[64];
    private int resultCount = 0;
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public EightQueen() {
        for (int index = 0; index < size * size; index++) {
            checkerboard[index] = 1;
        }
    }

    public void function(int[] tmp, int level) {
        int[] array;
        //是否是最后一行
        if (level == size - 1) {
            array = Arrays.copyOf(tmp, tmp.length);
            //循环最后一行的所以元素
            for (int index = 0; index < size; index++) {
                if (array[level * size + index] == 1) {
                    String ret = "";
                    //输出结果
                    for (int i = 0; i <= level * size + index; i++) {
                        if (array[i] == 1) {
                            ret += "(" + (i / size + 1) + "," + (i %
                                    size + 1) + ")";
                            System.out.print("(" + (i / size + 1) + "," + (i %
                                    size + 1) + ")");
                        }
                    }
                    System.out.println();
                    list.add(ret);
                    //置位当前最后一个元素
                    array[level * size + index] = 0;
                    resultCount++;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                array = Arrays.copyOf(tmp, tmp.length);
                //将已计算过的置位
                for (int i = 0; i < index; i++) {
                    array[level * size + i] = 0;
                }
                for (int j = 0; j < size; j++) {
                    if (array[level * size + j] == 1) {
                        index = j;
                        //计算元素所在行和列以及斜线
                        setZero(array, level, level * size + j);
                        function(array, level + 1);
                    }
                }
            }
        }
    }

    private void setZero(int[] tmp, int level, int pos) {
        int line = level;
        int currentColumn;
        int currentRow;
        int row;
        if (level == 0)
            row = pos;
        else {
            row = pos % size;
        }
        //行置零
        for (int index = 0; index < size; index++) {
            int currentPos = level * size + index;
            if (currentPos != pos) {
                tmp[currentPos] = 0;
            }
        }
        //列置零
        for (int index = 0; index < size; index++) {
            int currentPos = index * size + row;
            if (currentPos != pos) {
                tmp[currentPos] = 0;
            }
        }
        //右下
        for (int index = 1; index <= size; index++) {
            currentRow = level + index;
            currentColumn = row + index;
            if (currentRow >= size || currentColumn >= size) {
                break;
            } else {
                tmp[currentRow * size + currentColumn] = 0;
            }
        }
        //左上
        for (int index = 1; index <= size; index++) {
            currentRow = level - index;
            currentColumn = row - index;
            if (currentRow < 0 || currentColumn < 0) {
                break;
            } else {
                tmp[currentRow * size + currentColumn] = 0;
            }
        }
        //右上
        for (int index = 1; index <= size; index++) {
            currentRow = level - index;
            currentColumn = row + index;
            if (currentRow < 0 || currentColumn >= size) {
                break;
            } else {
                tmp[currentRow * size + currentColumn] = 0;
            }
        }
        //左下
        for (int index = 1; index <= size; index++) {
            currentRow = level + index;
            currentColumn = row - index;
            if (currentRow >= size || currentColumn < 0) {
                break;
            } else {
                tmp[currentRow * size + currentColumn] = 0;
            }
        }
    }

    public void getResult() {
        function(checkerboard, 0);
        System.out.println("result count:" + resultCount);
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.getResult();
    }
}
