package io.tyke.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Lottery extends TykeModel {
	@Id
	String Id;
	String name;
	String description;
	Date lotteryDate;
	double pointsPerSpendingUnit;
	double spendingUnit;
	double entryPoints;
	Date spendingValidityStartDate;
	Date spendingValidityEndDate;
	
	LotteryBrandForeignDocument brand;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLotteryDate() {
		return lotteryDate;
	}
	public void setLotteryDate(Date lotteryDate) {
		this.lotteryDate = lotteryDate;
	}
	public double getPointsPerSpendingUnit() {
		return pointsPerSpendingUnit;
	}
	public void setPointsPerSpendingUnit(double pointsPerSpendingUnit) {
		this.pointsPerSpendingUnit = pointsPerSpendingUnit;
	}
	public double getSpendingUnit() {
		return spendingUnit;
	}
	public void setSpendingUnit(double spendingUnit) {
		this.spendingUnit = spendingUnit;
	}
	public double getEntryPoints() {
		return entryPoints;
	}
	public void setEntryPoints(double entryPoints) {
		this.entryPoints = entryPoints;
	}
	public Date getSpendingValidityStartDate() {
		return spendingValidityStartDate;
	}
	public void setSpendingValidityStartDate(Date spendingValidityStartDate) {
		this.spendingValidityStartDate = spendingValidityStartDate;
	}
	public Date getSpendingValidityEndDate() {
		return spendingValidityEndDate;
	}
	public void setSpendingValidityEndDate(Date spendingValidityEndDate) {
		this.spendingValidityEndDate = spendingValidityEndDate;
	}
	public LotteryBrandForeignDocument getBrand() {
		return brand;
	}
	public void setBrand(LotteryBrandForeignDocument brand) {
		this.brand = brand;
	}
}
