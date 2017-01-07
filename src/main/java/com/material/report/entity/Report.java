package com.material.report.entity;

import com.sun.javafx.beans.annotations.NonNull;

/**
 * Created by Doing on 2017/1/7 0007.
 */
public class Report {
    private int finishedOrderCount;
    private int collectCount;
    private int singleCollectCount;
    private int successRecheckCount;
    private int hangUpCount;
    private int singleRecheckCount;
    private int produceCount;
    private int singleProduceCount;

    private int avgOrderTime;
    private int avgCollectTime;
    private int avgSingleCollectTime;
    private int avgSuccessRecheckTime;
    private int avgSingleRecheckTime;
    private int avgProduceTime;
    private int avgSingleProduceTime;

    @NonNull private String date;

    public Report() {
    }

    public Report(String date) {
        this.date = date;
    }

    public int getFinishedOrderCount() {
        return finishedOrderCount;
    }

    public void setFinishedOrderCount(int finishedOrderCount) {
        this.finishedOrderCount = finishedOrderCount;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public int getSingleCollectCount() {
        return singleCollectCount;
    }

    public void setSingleCollectCount(int singleCollectCount) {
        this.singleCollectCount = singleCollectCount;
    }

    public int getSuccessRecheckCount() {
        return successRecheckCount;
    }

    public void setSuccessRecheckCount(int successRecheckCount) {
        this.successRecheckCount = successRecheckCount;
    }

    public int getHangUpCount() {
        return hangUpCount;
    }

    public void setHangUpCount(int hangUpCount) {
        this.hangUpCount = hangUpCount;
    }

    public int getSingleRecheckCount() {
        return singleRecheckCount;
    }

    public void setSingleRecheckCount(int singleRecheckCount) {
        this.singleRecheckCount = singleRecheckCount;
    }

    public int getProduceCount() {
        return produceCount;
    }

    public void setProduceCount(int produceCount) {
        this.produceCount = produceCount;
    }

    public int getSingleProduceCount() {
        return singleProduceCount;
    }

    public void setSingleProduceCount(int singleProduceCount) {
        this.singleProduceCount = singleProduceCount;
    }

    public int getAvgOrderTime() {
        return avgOrderTime;
    }

    public void setAvgOrderTime(int avgOrderTime) {
        this.avgOrderTime = avgOrderTime;
    }

    public int getAvgCollectTime() {
        return avgCollectTime;
    }

    public void setAvgCollectTime(int avgCollectTime) {
        this.avgCollectTime = avgCollectTime;
    }

    public int getAvgSingleCollectTime() {
        return avgSingleCollectTime;
    }

    public void setAvgSingleCollectTime(int avgSingleCollectTime) {
        this.avgSingleCollectTime = avgSingleCollectTime;
    }

    public int getAvgSuccessRecheckTime() {
        return avgSuccessRecheckTime;
    }

    public void setAvgSuccessRecheckTime(int avgSuccessRecheckTime) {
        this.avgSuccessRecheckTime = avgSuccessRecheckTime;
    }

    public int getAvgSingleRecheckTime() {
        return avgSingleRecheckTime;
    }

    public void setAvgSingleRecheckTime(int avgSingleRecheckTime) {
        this.avgSingleRecheckTime = avgSingleRecheckTime;
    }

    public int getAvgProduceTime() {
        return avgProduceTime;
    }

    public void setAvgProduceTime(int avgProduceTime) {
        this.avgProduceTime = avgProduceTime;
    }

    public int getAvgSingleProduceTime() {
        return avgSingleProduceTime;
    }

    public void setAvgSingleProduceTime(int avgSingleProduceTime) {
        this.avgSingleProduceTime = avgSingleProduceTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Report{" +
                "finishedOrderCount=" + finishedOrderCount +
                ", collectCount=" + collectCount +
                ", singleCollectCount=" + singleCollectCount +
                ", successRecheckCount=" + successRecheckCount +
                ", hangUpCount=" + hangUpCount +
                ", singleRecheckCount=" + singleRecheckCount +
                ", produceCount=" + produceCount +
                ", singleProduceCount=" + singleProduceCount +
                ", avgOrderTime=" + avgOrderTime +
                ", avgCollectTime=" + avgCollectTime +
                ", avgSingleCollectTime=" + avgSingleCollectTime +
                ", avgSuccessRecheckTime=" + avgSuccessRecheckTime +
                ", avgSingleRecheckTime=" + avgSingleRecheckTime +
                ", avgProduceTime=" + avgProduceTime +
                ", avgSingleProduceTime=" + avgSingleProduceTime +
                ", date='" + date + '\'' +
                '}';
    }
}
