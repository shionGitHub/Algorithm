package com.yishion.algorithm.A.d7;

public class Code01_TrieTree {

	public static class TrieNode {

		public int pass;// ������ַ�����ʱ�����Ѿ�ͨ������ڵ���ٴ�
		public int end;// �ַ����Ƿ��Ե�ǰ�ڵ��β

		// ��ǰ�ڵ���¼��ڵ�ļ��ϣ�������['a' - 'z']26��Сд��ĸ����ʾ
		// nexts[0]��ʾ ��a·�� �����¼��ڵ�
		// nexts[1]��ʾ ��b·�� �����¼��ڵ�
		public TrieNode[] nexts;

		public TrieNode() {
			nexts = new TrieNode[26];
		}

	}

	// ǰ׺��--��ѧ�����֣���ʾ����
	public static class Trie {

		public TrieNode root;

		public Trie() {
			root = new TrieNode();// ������ʱ���ʼ���ø��ڵ�
		}

		// ����һ���ַ���
		public void insert(String word) {
			if (word == null) {
				return;
			}

			char[] ch = word.toCharArray();// �ַ���ת����char����
			TrieNode cur = root;// ��ǰ�ڵ�ָ����ڵ�
			root.pass++;// Ҫ���һ���ַ�������ͨ����·��

			for (int i = 0; i < ch.length; i++) {
				int index = ch[i] - 'a';// ���char�ַ���Ӧ�����е�λ��
				if (cur.nexts[index] == null) {// ��ǰ�ڵ���a·��ͨ����һ���ڵ���û��
					cur.nexts[index] = new TrieNode();
				}
				cur = cur.nexts[index];// curָ������ڵ�
				cur.pass++;
			}
			// �ַ��������˵Ļ�
			cur.end++;
		}

		// ɾ��һ���ַ���
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

		// ��ѯһ���ַ��������˶��ٴ�
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

		// ��ѯ��һ��ǰ׺�����˶��ٴ�
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
