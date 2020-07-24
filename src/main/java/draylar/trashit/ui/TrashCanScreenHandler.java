package draylar.trashit.ui;

import draylar.trashit.TrashIt;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerType;
import spinnery.common.handler.BaseScreenHandler;
import spinnery.widget.WInterface;
import spinnery.widget.WSlot;

public class TrashCanScreenHandler extends BaseScreenHandler {

    public TrashCanScreenHandler(int synchronizationID, PlayerInventory playerInventory) {
        super(synchronizationID, playerInventory);
        WInterface mainInterface = getInterface();
        addInventory(1, new SimpleInventory(9 * 3));

        // add inventories
        WSlot.addHeadlessPlayerInventory(mainInterface);
        WSlot.addHeadlessArray(mainInterface, 0, 1, 9, 3);
    }

    @Override
    public ScreenHandlerType<?> getType() {
        return TrashIt.TRASH_CAN_CONTAINER;
    }
}
