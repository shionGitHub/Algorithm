package com.yishion.algorithm.A.d6;

import java.util.ArrayList;

public class Node {

	public int value;
	public int in;
	public int out;

	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;

	public Node(int value) {
		this.value = value;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}

}
