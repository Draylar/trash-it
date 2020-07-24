package draylar.trashit;

import draylar.trashit.block.TrashCanBlock;
import draylar.trashit.ui.TrashCanScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TrashIt implements ModInitializer {

    public static final Block TRASH_CAN = Registry.register(Registry.BLOCK, id("trash_can"), new TrashCanBlock());
    public static final Item TRASH_CAN_ITEM = Registry.register(Registry.ITEM, id("trash_can"), new BlockItem(TRASH_CAN, new Item.Settings().group(ItemGroup.MISC)));
    public static final ScreenHandlerType<TrashCanScreenHandler> TRASH_CAN_CONTAINER = ScreenHandlerRegistry.registerSimple(id("coin_pack"), TrashCanScreenHandler::new);

    @Override
    public void onInitialize() {

    }

    public static Identifier id(String name) {
        return new Identifier("trash-it", name);
    }
}
