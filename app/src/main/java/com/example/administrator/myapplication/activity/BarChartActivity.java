package com.example.administrator.myapplication.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.DefaultYAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BarChartActivity extends AppCompatActivity {
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.bc_mainAct)
    BarChart barChart1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);
        ButterKnife.bind(this);
        initChart();
    }

    public void initChart(){
        barChart1.setDrawValueAboveBar(true);//设置值是否在矩形上方显示
        barChart1.setDescription("");//设置右下角描述
//        barChart1.setNoDataText("没有数据");//没有数据时显示
//        barChart1.setMaxVisibleValueCount(60);
        barChart1.setTouchEnabled(true);//设置是否可以触摸
        barChart1.setDragEnabled(true);//设置可以拖拽
        barChart1.setScaleEnabled(true);//是否可以缩放
        barChart1.setPinchZoom(false);//集双指缩放
//        barChart1.setDrawGridBackground(false);//是否显示表格颜色
//        barChart1.setGridBackgroundColor(Color.GRAY);//设置表格颜色

        //设置比例显示
        Legend legend = barChart1.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);//设置比例显示在柱形图那个位置
        legend.setForm(Legend.LegendForm.CIRCLE);//设置比例显示的形状（方形，圆形，线性）
        legend.setFormSize(8f);//设置比例显示形状大小
        legend.setTextSize(10f);//显示文字大小
        legend.setXEntrySpace(4f);

        /**
         * x轴样式设置
         */
        XAxis xAxis = barChart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴标签显示的位置
        xAxis.setTypeface(Typeface.DEFAULT);
        xAxis.setDrawGridLines(false);//不绘制格网线
        xAxis.setSpaceBetweenLabels(2);//设置x标签的间隙

        /**
         * y轴样式设置
         */
        //设置柱形图左边y轴方向上的属性
        YAxis leftAxis = barChart1.getAxisLeft();
        leftAxis.setTypeface(Typeface.DEFAULT);
        //设置y轴上的标签数,boolean值为true代表必须8个
        leftAxis.setLabelCount(8, false);
//        leftAxis.setValueFormatter(new DefaultYAxisValueFormatter(0));
        //设置标签在柱形图的哪个位置
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        //设置y轴标签之间的间距
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        //设置柱形图右边y轴方向上的属性,属性含义与上面相同
        YAxis rightAxis = barChart1.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setTypeface(Typeface.DEFAULT);
        rightAxis.setLabelCount(5, true);
        rightAxis.setValueFormatter(new DefaultYAxisValueFormatter(0));
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinValue(1f); // this replaces setStartAtZero(true)

        // 隐藏右边的坐标轴
        barChart1.getAxisRight().setEnabled(false);
        // 隐藏左边的坐标轴(同上)
//        barChart.getAxisLeft().setEnabled(false);
        setData(15);

    }

    /**
     * 绑定数据
     * @param count x轴上的标签数
     */
    private void setData(int count) {
        //设置x轴方向上的标签数据
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add(String.valueOf(i+1));
        }
        //设置每个矩形在y轴上的值
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        for (int i = 0; i < count; i++) {
            yVals1.add(new BarEntry(2*i, i));
        }

        //第一个参数是各个矩形在y轴方向上的值得集合，第二个参数为比例的文字说明
        BarDataSet set1 = new BarDataSet(yVals1, "不同颜色代表不同的值");
        //设置矩形之间的间距，参数为百分数，可控制矩形的宽度
        set1.setBarSpacePercent(10f);
        //设置矩形的颜色
        int colors[]={0xffff0000,0xff00ff00,0xff0000ff};
        set1.setColors(colors);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        //设置柱形图的数据
        BarData data = new BarData(xVals, dataSets);
        data.setValueTextSize(10f);
        data.setValueTypeface(Typeface.DEFAULT);

        barChart1.setData(data);
    }

}

