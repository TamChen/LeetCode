package com.csust.code;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        	if (points.length<=2) {
   			return points.length;
   		}//如果长度小于2则返回该长度
       	double ktemp;int maxNum=0;int ymax=0;
       	Map<Double,Integer> map=new HashMap<Double,Integer>();//存放斜率的
       	//根据一点，然后找到以该点为起点上的直线上的所有点，比较出最大的那个值即为所求
       	for (int i = 0; i < points.length; i++) {
       		map.clear();
   			int duplicate=0,ymaxnum=0,max=0;
   			for (int j = i; j < points.length; j++) {
   				if (j==i) continue;
   				if (points[i].x==points[j].x&&points[i].y==points[j].y) {
   					duplicate=duplicate+1;continue;//考虑起点处
   				}if (points[i].x==points[j].x) {
					ymaxnum++;//在同一竖直线上  考虑斜率不存在的情况
				}else{
					if (points[i].y==points[j].y) {
						ktemp=0;//在同一水平直线上
					}else {
		   				ktemp=((double)(points[j].y-points[i].y))/(points[j].x-points[i].x);
					}
	   				if (map.containsKey(ktemp)) {
	   					map.put(ktemp, map.get(ktemp)+1);
	   				}else map.put(ktemp, 2);
				} 
   			}
   			//找到斜率相同的直线中最多点的个数
   	       	for(Entry<Double, Integer> entry:map.entrySet()){  
   	       		if (entry.getValue()>max) {
					max=entry.getValue();}
   	       	} //找到同一横坐标与y轴平行的线上点最多的那条线
   	       	if(ymaxnum>ymax)
   	       		ymax=ymaxnum;
   	       	int tempmaxNum= (duplicate+max)>ymax?(duplicate+max):ymax;
   	       	if (map.size()==0) {//考虑几个点都在一个位置的情况
				tempmaxNum=tempmaxNum+1;
			}//找到每个点出发后的最多点
   	       	if (tempmaxNum>maxNum) {
				maxNum=tempmaxNum;
			}
   		}
       	return maxNum;
    }
}
