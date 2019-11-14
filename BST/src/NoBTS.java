public class NoBTS {

	private int value;
	private NoBTS left;
	private NoBTS right;

	NoBTS(int value) {

		this.value = value;
		this.left = null;
		this.right = null;

	}

	public static void mountTree(NoBTS novo, NoBTS tree) {

		if (tree == null) {

			tree = novo;

		} else {

			if (novo.value < tree.value) {

				if (tree.left == null) {

					tree.left = novo;

				} else {

					mountTree(novo, tree.left);

				}

			} else {

				if (tree.right == null) {

					tree.right = novo;

				} else {

					mountTree(novo, tree.right);
				}

			}

		}

	}

	public static boolean searchNo(NoBTS tree, int value) {

		if (tree == null) {

			return false;

		}

		if (tree.value == value) {

			return true;

		}

		if (tree.value > value) {
			return searchNo(tree.left, value);

		} else {

			return searchNo(tree.right, value);
		}

	}

	public static void removeNo(NoBTS tree, int value) {

		if (tree.value == value) {

			tree = null;

		}

		if (tree.value > value) {

			if (tree.left.value == value) {
				schemeRemoveNoLeft(tree);

			} else {

				removeNo(tree.left, value);
			}

		}

		if (tree.right.value == value) {

			schemeRemoveRight(tree);

		} else {

			removeNo(tree.right, value);
		}
	}

	public static void schemeRemoveNoLeft(NoBTS noFather) {
		int son = 0;

		NoBTS noRemove = null;
		noRemove = noFather.right;
		son = totalSon(noRemove);

		if (son == 0) {

			removeNoSon(noFather, "D");

		}

		if (son == 1) {

			removeSonRight(noFather, "E");

		}

		if (son == 2) {

			removeSonRight(noFather, "D");

		}

	}

	public static int totalSon(NoBTS no) {

		int total = 0;

		if (no.left != null) {

			total += 1;

		} else if (no.right != null) {

			total += 2;

		}

		return total;

	}

	public static void removeNoSon(NoBTS noFather, String subtree) {

		if (subtree.contentEquals("E")) {

			noFather.left = null;

		} else {

			noFather.right = null;
		}

	}

	public static void removeSonRight(NoBTS noFather, String subtree) {

		if (subtree.contentEquals("E")) {

			noFather.right = noFather.right.left;

		} else {

			noFather.right = noFather.right.right;
		}

	}

	public static void schemeRemoveRight(NoBTS noFather) {

		int son = 0;

		NoBTS noRemove = null;

		noRemove = noFather.right;

		son = totalSon(noRemove);

		if (son == 0) {

			removeNoSon(noFather, "D");
		}

		if (son == 1) {

			removeSonRight(noFather, "E");
		}

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public NoBTS getLeft() {
		return left;
	}

	public void setLeft(NoBTS left) {
		this.left = left;
	}

	public NoBTS getRight() {
		return right;
	}

	public void setRight(NoBTS right) {
		this.right = right;
	}

}