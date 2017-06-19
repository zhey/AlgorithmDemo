package com.zhey.eightqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhey on 17-6-18.
 */
public class EightQueen2 {
    private int size;
    private int[] checkerBoard;
    private int resultCount = 0;
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public EightQueen2(int size) {
        this.size = size;
        checkerBoard = new int[size];
        for (int level = 0; level < size; level++) {
            checkerBoard[level] = -1;
        }
    }

    public void function() {
        for (int level = 0; level < size && level >= 0; level++) {
            if (checkerBoard[level] == size - 1) {
                checkerBoard[level] = -1;
                level -= 2;
            } else {
                for (int column = checkerBoard[level] + 1; column < size;
                     column++) {
                    if (canSet(level, column)) {
                        checkerBoard[level] = column;
                        if (level == size - 1) {
                            list.add(Arrays.toString(checkerBoard));
                            resultCount++;
                            //找到结果
                        } else {
                            break;
                        }

                    } else if (column == size - 1) {
                        //本行没有可放置皇后的位置则回到上层继续计算
                        checkerBoard[level] = -1;
                        level -= 2;

                    }
                }
            }
            if (level == size - 1) {
                checkerBoard[level] = -1;
                level -= 2;
            }
        }
    }

    private boolean canSet(int level, int pos) {
        for (int index = 0; index < level; index++) {
            if (checkerBoard[index] == pos) {
                return false;
            } else if (Math.abs(level - index) == Math.abs(pos -
                    checkerBoard[index])) {
                return false;
            }
        }
        return true;
    }

    public void getResult() {
        function();
        System.out.println("result count：" + resultCount);
    }

    public static void main(String[] args) {
        EightQueen2 eightQueen2 = new EightQueen2(8);
        eightQueen2.getResult();
    }
}
