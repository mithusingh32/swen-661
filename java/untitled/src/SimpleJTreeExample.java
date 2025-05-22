import javax.swing.*;
import javax.swing.tree.*;

public class SimpleJTreeExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTree Example");

        // Create the root node and child nodes
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        DefaultMutableTreeNode grandchild = new DefaultMutableTreeNode("Grandchild 1.1");
        DefaultMutableTreeNode grandchild2 = new DefaultMutableTreeNode("Grandchild 2.1");
        child1.add(grandchild);
        child2.add(grandchild2);
        root.add(child1);
        root.add(child2);

        // Create the JTree
        JTree tree = new JTree(root);

        // Add the tree to a scroll pane and frame
        frame.add(new JScrollPane(tree));
        frame.setSize( 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode =
                    (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode != null) {
                System.out.println("Selected: " + selectedNode.getUserObject());
            }
        });

        // Expand the first child node
        TreePath path = new TreePath(child1.getPath());
        tree.expandPath(path);

        // Collapse the child node
        tree.collapsePath(path);

DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
final Icon openIcon = UIManager.getIcon("OptionPane.questionIcon");
final Icon closeIcon = UIManager.getIcon("OptionPane.errorIcon");
final Icon leafIcon = UIManager.getIcon("OptionPane.informationIcon");
renderer.setLeafIcon(leafIcon);
renderer.setOpenIcon(openIcon);
renderer.setClosedIcon(closeIcon);

    }
}
            

