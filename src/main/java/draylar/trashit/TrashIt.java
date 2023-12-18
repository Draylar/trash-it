package draylar.trashit;

import draylar.trashit.block.TrashCanBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TrashIt implements ModInitializer {

    public static final Block TRASH_CAN = Registry.register(Registries.BLOCK, id("trash_can"), new TrashCanBlock());
    public static final Item TRASH_CAN_ITEM = Registry.register(Registries.ITEM, id("trash_can"), new BlockItem(TRASH_CAN, new FabricItemSettings()));

    @Override
    public void onInitialize() {

        // Add "Trash Can" item to the REDSTONE ItemGroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(new ItemStack(TRASH_CAN_ITEM));
        });
    }

    public static Identifier id(String name) {
        return new Identifier("trash-it", name);
    }
}
