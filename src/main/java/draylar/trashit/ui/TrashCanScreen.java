package draylar.trashit.ui;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import spinnery.client.screen.BaseHandledScreen;
import spinnery.widget.*;
import spinnery.widget.api.Position;
import spinnery.widget.api.Size;

public class TrashCanScreen extends BaseHandledScreen<TrashCanScreenHandler> {

    public TrashCanScreen(TrashCanScreenHandler handler, PlayerInventory playerInventory, Text name) {
        super(handler, playerInventory, name);

        // base panel
        WInterface baseInterface = getInterface();
        WPanel panel = baseInterface.createChild(WPanel::new).setSize(Size.of(176, 166));

        // setup positioning
        panel.center();
        panel.setOnAlign(WAbstractWidget::center);

        // label
        panel.createChild(WStaticText::new).setLabel("Trash Can").setPosition(Position.of(panel, 0, 0, 0));

        // add inventories
        WSlot.addPlayerInventory(Position.of(panel, 7, 83), Size.of(18, 18), panel);
        WSlot.addArray(Position.of(panel, 7, 16), Size.of(18, 18), panel, 0, 1, 9, 3);
    }
}
