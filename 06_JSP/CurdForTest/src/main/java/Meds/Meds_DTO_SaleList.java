package Meds;

import java.util.ArrayList;
import java.util.List;

public class Meds_DTO_SaleList {
	private int sellNo;
	private List<String> sellName = new ArrayList<>();
	private List<String> sellMadeby = new ArrayList<>();
	private List<Integer> sellOut = new ArrayList<>();
	private List<Integer> sellQuantity = new ArrayList<>();
	private String sellTotal;
	private String sellDate;
	private String sellStatus;
	
	
	public String getSellTotal() {
		return sellTotal;
	}
	public void setSellTotal(String sellTotal) {
		this.sellTotal = sellTotal;
	}
	public int getSellNo() {
		return sellNo;
	}
	public void setSellNo(int sellNo) {
		this.sellNo = sellNo;
	}
	public List<String> getSellName() {
		return sellName;
	}
	public void setSellName(String sellName) {
		this.sellName.add(sellName);
	}
	public List<String> getSellMadeby() {
		return sellMadeby;
	}
	public void setSellMadeby(String sellMadeby) {
		this.sellMadeby.add(sellMadeby);
	}
	public List<Integer> getSellOut() {
		return sellOut;
	}
	public void setSellOut(Integer sellOut) {
		this.sellOut.add(sellOut);
	}
	public List<Integer> getSellQuantity() {
		return sellQuantity;
	}
	public void setSellQuantity(Integer sellQuantity) {
		this.sellQuantity.add(sellQuantity);
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public String getSellStatus() {
		return sellStatus;
	}
	public void setSellStatus(String sellStatus) {
		this.sellStatus = sellStatus;
	}	
}
