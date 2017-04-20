package com.problems.datastructures.binarysearchtrees;

import java.util.Objects;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int N;

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (Objects.isNull(x)){
			return 0;
		}
		return x.N;
	}
	public Value get(Key key){
		return get(root,key);
	}
	private Value get(Node x,Key k){
		if(Objects.isNull(x)){
			return null;
		}
		int cmp = k.compareTo(x.key);
		if(cmp < 0){
			return get(x.left,k);
		}else if(cmp > 0){
			return get(x.right,k);
		}else{
			return x.value;
		}
	}
	public void put(Key key, Value value){
		root = put(root,key,value);
	}
	private Node put(Node x,Key key,Value value){
		if(Objects.isNull(x)){
			return new Node(key,value,1);
		}else{
			int cmp = key.compareTo(x.key);
			if(cmp < 0){
				return put(x.left,key,value);
			}else if(cmp > 0){
				return put(x.right,key,value);
			}else{
				x.value = value;
				x.N = size(x.left) + size(x.right);
				return x;
			}
		}
	}
	public Key min(){
		if(Objects.isNull(root)){
			return null;
		}
		return min(root).key;
	}
	private Node min(Node x){
		if(Objects.isNull(x.left)){
			return x;
		}else{
			return min(x.left);
		}
	}
	public Key max(){
		if(Objects.isNull(root)){
			return null;
		}
		return max(root).key;
	}
	private Node max(Node x){
		if(Objects.isNull(x.right)){
			return x;
		}else{
			return max(x.right);
		}
	}
}
