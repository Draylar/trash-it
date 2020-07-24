package draylar.trashit;

import draylar.trashit.ui.TrashCanScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class TrashItClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(TrashIt.TRASH_CAN_CONTAINER, TrashCanScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(TrashIt.TRASH_CAN, RenderLayer.getCutout());
    }
}
