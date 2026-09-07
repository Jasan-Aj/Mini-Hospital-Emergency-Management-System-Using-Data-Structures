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