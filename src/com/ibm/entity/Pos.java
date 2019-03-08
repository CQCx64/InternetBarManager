package com.ibm.entity;

public class Pos {
	
	private int id;
	private String name;
	private int price;
	private String cpu;
	private String board;
	private String graphics;
	private String memory;
	private String sata;
	private String ssd;
	private String monitor;
	
	
	public Pos() {
		super();
	}

	public Pos(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Pos(int id, String name, int price, String cpu, String board, String graphics, String memory, String sata,
			String ssd, String monitor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cpu = cpu;
		this.board = board;
		this.graphics = graphics;
		this.memory = memory;
		this.sata = sata;
		this.ssd = ssd;
		this.monitor = monitor;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getGraphics() {
		return graphics;
	}

	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getSata() {
		return sata;
	}

	public void setSata(String sata) {
		this.sata = sata;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	
	
}
