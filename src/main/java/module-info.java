module edu.farmingdale.csc311_assignment3_groupbased {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.csc311_assignment3_groupbased to javafx.fxml;
    exports edu.farmingdale.csc311_assignment3_groupbased;
}