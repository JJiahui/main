package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.expenditure.Expenditure;

/**
 * Panel containing the list of persons.
 */
public class ExpenditureListPanel extends UiPart<Region> {
    private static final String FXML = "ExpenditureListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ExpenditureListPanel.class);

    @FXML
    private ListView<Expenditure> expenditureListView;

    public ExpenditureListPanel(ObservableList<Expenditure> expenditureList) {
        super(FXML);
        expenditureListView.setItems(expenditureList);
        expenditureListView.setCellFactory(listView -> new ExpenditureListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Expenditure} using a {@code ExpenditureCard}.
     */
    class ExpenditureListViewCell extends ListCell<Expenditure> {
        @Override
        protected void updateItem(Expenditure expenditure, boolean empty) {
            super.updateItem(expenditure, empty);

            if (empty || expenditure == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ExpenditureCard(expenditure, getIndex() + 1).getRoot());
            }
        }
    }

}
