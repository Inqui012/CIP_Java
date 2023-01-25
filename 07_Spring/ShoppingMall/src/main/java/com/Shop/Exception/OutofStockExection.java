package com.Shop.Exception;

// 스스로 작성하는 예외처리객체.
public class OutofStockExection extends RuntimeException {
	public OutofStockExection(String message) {
		super(message);
	}
}
