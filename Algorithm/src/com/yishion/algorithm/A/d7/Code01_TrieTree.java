package com.yishion.algorithm.A.d7;

public class Code01_TrieTree {

	public static class TrieNode {

		public int pass;// 在添加字符串的时候有已经通过这个节点多少次
		public int end;// 字符串是否以当前节点结尾

		// 当前节点的下级节点的集合，这里以['a' - 'z']26个小写字母来表示
		// nexts[0]表示 以a路径 到达下级节点
		// nexts[1]表示 以b路径 到达下级节点
		public TrieNode[] nexts;

		public TrieNode() {
			nexts = new TrieNode[26];
		}

	}

	// 前缀树--科学家名字，表示尊重
	public static class Trie {

		public TrieNode root;

		public Trie() {
			root = new TrieNode();// 创建的时候初始化好根节点
		}

		// 增加一个字符串
		public void insert(String word) {
			if (word == null) {
				return;
			}

			char[] ch = word.toCharArray();// 字符串转化成char数组
			TrieNode cur = root;// 当前节点指向根节点
			root.pass++;// 要添加一个字符串，有通过的路径

			for (int i = 0; i < ch.length; i++) {
				int index = ch[i] - 'a';// 这个char字符对应数组中的位置
				if (cur.nexts[index] == null) {// 当前节点以a路径通往下一个节点有没有
					cur.nexts[index] = new TrieNode();
				}
				cur = cur.nexts[index];// cur指向这个节点
				cur.pass++;
			}
			// 字符串结束了的话
			cur.end++;
		}

		// 删除一个字符串
		public void delete(String word) {
			if (search(word) != 0) {
				root.pass--;
				TrieNode curr = root;
				char[] ch = word.toCharArray();
				for (int i = 0; i < ch.length; i++) {
					int index = ch[i] - 'a';
					curr.nexts[index].pass--;
					if (curr.nexts[index].pass == 0) {
						curr.nexts[index] = null;
						return;
					}
					curr = curr.nexts[index];
				}
				curr.end--;
			}
		}

		// 查询一个字符串出现了多少次
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] ch = word.toCharArray();
			TrieNode curr = root;

			for (int i = 0; i < ch.length; i++) {
				int index = ch[i] - 'a';
				if (curr.nexts[index] == null) {
					return 0;
				}
				curr = curr.nexts[index];
			}
			return curr.end;
		}

		// 查询出一个前缀出现了多少次
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}

			char[] ch = pre.toCharArray();
			TrieNode curr = root;
			for (int i = 0; i < ch.length; i++) {
				int index = ch[i] - 'a';
				if (curr.nexts[index] == null) {
					return 0;
				}
				curr = curr.nexts[index];
			}
			return curr.pass;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));
	}

}
