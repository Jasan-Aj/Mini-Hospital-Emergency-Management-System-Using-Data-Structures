public class PatientTree {

    private TreeNode root;

    public PatientTree() {
        root = null;
    }

    public void addPatient(Patient patient) {
        if (root == null) {
            root = new TreeNode(patient);
            return;
        }
        TreeNode current = root;
        while (true) {
            if (patient.getId() < current.data.getId()) {
                if (current.left == null) {
                    current.left = new TreeNode(patient);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(patient);
                    return;
                }
                current = current.right;
            }
        }
    }

    public Patient findPatient(int id) {
        TreeNode current = root;
        while (current != null) {
            if (id == current.data.getId()) {
                return current.data;
            }
            if (id < current.data.getId()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void deletePatient(int id) {
        root = deleteStep(root, id);
    }

    private TreeNode deleteStep(TreeNode node, int id) {
        if (node == null) {
            return null;
        }
        if (id < node.data.getId()) {
            node.left = deleteStep(node.left, id);
        } else if (id > node.data.getId()) {
            node.right = deleteStep(node.right, id);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Patient replacement = smallestOnRight(node.right);
            node.data = replacement;
            node.right = deleteStep(node.right, replacement.getId());
        }
        return node;
    }

    private Patient smallestOnRight(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public void showAll() {
        if (root == null) {
            System.out.println("No patients registered yet.");
            return;
        }
        System.out.println("========== REGISTERED PATIENTS ==========");
        displayBranch(root);
    }

    private void displayBranch(TreeNode node) {
        if (node == null) {
            return;
        }
        displayBranch(node.left);
        node.data.showCard();
        System.out.println("-----------------------------------------");
        displayBranch(node.right);
    }
}